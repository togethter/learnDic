### fastlane安装
	1、快速通道是自动化 iOS 和安卓应用程序 Beta 版部署和发布的最简单方法。它处理所有繁琐的任务例如生成屏幕截图、
	处理代码签名和发布应用程序。
	
	2、mac安装：
	 brew install fastlane
	
	3、设置环境变量(未设置讲导致够条件和上传构建时出现问题。在shell配置文件中添加一下行。根据系统，可以在~/.bashrc、
	~/.bash_profile、~/.profile或~/.zshrc找到您的shell配置文件	)
		export LC_ALL=en_US.UTF-8
		export LANG=en_US.UTF-8
	
###在iOS或者Android应用程序路径初始化fastlane
		1、fastlane init （通过命令后生成fastlane/FastFile等相关文件）

### 	使用fastlane部署iOSBeta版构建您的应用程序
		Fastlane负责使用名为build_app的操作构建应用程序，只需将以下内容添加到您的Fastfile中：
		
		lane :beta do
			build_app(scheme: "MyApp")
		end
		
	此外，可以指定更多构建应用程序的选项，例如
		lane :beta do
			build_app(scheme: "MyApp",
				            workspace: "Example.xcworkspace",
					            include_bitcode: true)
		end
	
	尝试使用
		fastlane beta（如果一切正常，您应该在当前目录中有一个[ProductName].ipa文件。要获取build_app的所有可用参数的列		表，请运行fastlane action build_app）
	
### 	上传您的应用程序
		构建应用程序后，它就可以上传到您选择的测试服务中。
		会自动将生成的.ipa文件的信息从build_app传递给您选择的beta测试提供商

		lane :beta do
		 sync_code_signing(type: "appstore")    # see code signing guide for more information
		   build_app(scheme: "MyApp")
		     upload_to_testflight
		       slack(message: "Successfully distributed a new beta build")
		 end
		 要获取给定操作的所有可用参数的列表，请运行 
		 	fastlane action slack

### 		上传TestFlight 	
			lane :beta do
			  # ..
			  build_app
			  upload_to_testflight  
			 end
		一些用示例
			lane :beta do
			  # ...
			  build_app
			
			  # Variant 1: Provide a changelog to your build
			  upload_to_testflight(changelog: "Add rocket emoji")
			
			  # Variant 2: Skip the "Waiting for processing" of the binary
			  #   While this will speed up your build, it will not distribute
			  #   the binary to your tests, nor set a changelog
			  upload_to_testflight(skip_waiting_for_build_processing: true)
			end	 
			如果您使用fastlane init设置fastlane，您的Apple ID将存储在fastlane/Appfile中，你可以使用
			upload_to_testflight(username: "bot@fastlane.tools").覆盖用户名

			获取更多可用选项列表，请运行 fastlane action upload_to_testflight
			可以自动管理测试人员，查看可用的其他操作。
###		Firebase应用分发
			安装Firebase应用插件		fastlane add_plugin firebase_app_distribution

			lane :beta do
			  # ...
			  build_app
			
			  firebase_app_distribution(
			    app: "1:123456789:ios:abcd1234",
			    groups: "qa-team, trusted-testers"
			  )
			  # ...
			end
有关更多信息和选项(例如添加发布说明)，请参考完整的[入门指针](https://firebase.google.com/docs/app-distribution/ios/distribute-fastlane)

有关其他受支持测试服务的更多信息，请参考[测试操作列表](https://docs.fastlane.tools/actions/#beta)
### 	发行说明	
	1、自动基于git提交
		lane :beta do
		  sync_code_signing
		  build_app
		  changelog_from_git_commits # this will generate the changelog based on your last commits
		  upload_to_testflight
		end
		
	使用fastlane action changelog_from_git_commits获取所有可用选项的列表，以下是一些示例
		changelog_from_git_commits(
		  between: ['7b092b3', 'HEAD'], # Optional, lets you specify a revision/tag range between which to collect commit info
		  merge_commit_filtering: exclude_merges # Optional, lets you filter out merge commits
		)
		
	2、更改日志提示
		可以使用提示操作在终端中自动询问更改日志：
		
		lane :beta do
		  # Variant 1: Ask for a one line input
		  changelog = prompt(text: "Changelog: ")
		
		  # Variant 2: Ask for a multi-line input
		  #   The user confirms their input by typing `END` and Enter
		  changelog = prompt(
		    text: "Changelog: ",
		    multi_line_end_keyword: "END"
		  )
		
		  sync_code_signing
		  build_app
		
		  upload_to_testflight(changelog: changelog)
		end	
		
	3、从文件系统或远程服务器获取更改日志
		可以从Fastfile中的任何地方获取值，包括文件系统和远程服务器
		lane :beta do
		  # Variant 1: Read from file system
		  #   note the `..`, since fastlane runs in the _fastlane_ directory
		  changelog = File.read("../Changelog.txt")
		
		  # Variant 2: Fetch data from a remote web server
		  changelog = download(url: "https://lookatmycms.com/changelog.txt")
		
		  sync_code_signing
		  build_app
		
		  upload_to_testflight(changelog: changelog)
		end		

###使用fastlane管理设备和测试人员
	1、TestFlight
	如果您使用TestFlight，您无需担心设备的UDID。相反，您只需根据测试人员的 Apple ID 电子邮件地址维护他们的列表
	fastlane支持使用不同方法自动注册设备
	
		1、网页将手机添加到TestFlight。[用户的Apple ID地址填入网页](https://github.com/fastlane/boarding#readme)
		2、使用fastlane添加单个测试任务到TestFlight
			
			# Register a new external tester
			fastlane pilot add email@invite.com

			# Register a new external tester and add them to your app
			fastlane pilot add email@invite.com -a com.app.name
			
	2、第三放测试服务
		如果您使用的是第三方测试服务，您需要管理您的注册设备及其UDID。快速通道已经支持设备注册和开箱即用更新预置配置
		文件。
		
		lane :beta do
		  # Before calling match, we make sure all our devices are registered on the Apple Developer Portal
		  register_devices(devices_file: "devices.txt")
		
		  # After registering the new devices, we'll make sure to update the provisioning profile if necessary
		  # Note how we make sure to pass "adhoc" to get and use a provisioning profile for Ad Hoc distribution
		  sync_code_signing(force_for_new_devices: true, type: "adhoc")
		  build_app
		  # ...
		end
		
		devices.txt应该是这样的：
		
		Device ID Device Name
		A123456789012345678901234567890123456789  DeviceName1
		B123456789012345678901234567890123456789  DeviceName2
###	增加版本号
		根据您使用的测试服务，每次上传新版本时，您都必须增加生成号。例如，这是TestFlight的一项要求。
		为此，有一些内置的快速通道操作可用，以下是一些示例
### 	从TestFlight获取最新版本
		下面的代码示例将使用TestFlight的最新构建号并临时设置它
		
		lane :beta do
		  increment_build_number(
		    build_number: latest_testflight_build_number + 1,
		    xcodeproj: "Example.xcodeproj"
		  )
		end
###	将生成号提交到版本控制
		下面的代码示例将增加生成号，并将项目更改提交到版本控制。
		lane :beta do
		  # Ensure that your git status is not dirty
		  ensure_git_status_clean
		
		  # Increment the build number (not the version number)
		  # Providing the xcodeproj is optional
		  increment_build_number(xcodeproj: "Example.xcodeproj")
		
		  # Commit the version bump
		  commit_version_bump(xcodeproj: "Example.xcodeproj")
		
		  # Add a git tag for this build. This will automatically
		  # use an appropriate git tag name
		  add_git_tag
		
		  # Push the new commit and tag back to your git remote
		  push_to_git_remote
		end
		对于上述所有步骤，有更多参数可用，请运行以下步骤以获取完整列表：
		
###	使用提交数量
		不建议这样做，但一些团队更喜欢这种方法。您可以使用当前分支的提交数（通过 number_of_commits）作为生成号。
		只有当您始终在同一分支上运行构建时，这才能工作。
		
		lane :beta do
		  increment_build_number(build_number: number_of_commits)
		end


###	使用fastlane部署iOS App Store构建您的应用程序
		Fastlane负责使用名为build_app的操作构建应用程序，只需将以下内容添加到您的Fastfile中：
	
		lane :release do
		  build_app(scheme: "MyApp")
		end
		
		此外，您可以指定更多构建应用程序的选项，例如
		
		lane :release do
		  build_app(scheme: "MyApp",
		            workspace: "Example.xcworkspace",
		            include_bitcode: true)
		end

		尝试使用
		fastlane release
		
		如果一切正常，您应该在当前目录中有一个[ProductName].ipa文件。
		要获取build_app的所有可用参数的列表，请运行fastlane action build_app。
	
有可能因为前一步的代码签名而出了问题。我们准备了自己的[代码签名指针](http://docs.fastlane.tools/codesigning/getting-started/)指南，帮助您为项目设置正确的代码签名方法。
	
###	生成屏幕截图
要了解有关如何自动生成 App Store 屏幕截图的更多信息，请查看 [适用于 iOS 和 tvOS 的快速通道屏幕截图](http://docs.fastlane.tools/getting-started/ios/screenshots/)
	
		
###	上传二进制和应用程序元数据
		构建应用程序后，它就可以上传到App Store了。如果您已经使用快速通道跟踪 iOS Beta 版部署，
		则以下代码可能看起来已经相似了。
			lane :release do
			  capture_screenshots                  # generate new screenshots for the App Store
			  sync_code_signing(type: "appstore")  # see code signing guide for more information
			  build_app(scheme: "MyApp")
			  upload_to_app_store                  # upload your app to App Store Connect
			  slack(message: "Successfully uploaded a new App Store build")
			end
						
		有关每个步骤的所有选项的列表，请运行fastlane action [action_name]。

有关upload_to_app_store的工作方式的详细信息，以及如何定义更多选项，请查看 [upload_to_app_store](http://docs.fastlane.tools/actions/upload_to_app_store/)

### 最佳实践
		推送通知
	为了确保最新的推送通知证书在提交过程中仍然有效，请在fastlane开始处添加以下内容：
		lane :release do
		  get_push_certificate
		  # ...
		end
	get_push_certificate将确保您的证书至少还有效两周，如果无效，则创建一个新证书。
	如果您还没有任何推送证书，则get_push_certificate将为您创建一个推送证书并将其本地存储在项目目录中。
	要获取有关可用选项的更多信息，请运行fastlane action get_push_certificate。
### 增加生成号
		下面的代码示例将使用App Store Connect的最新构建号并临时设置它
		lane :beta do
		  increment_build_number(
		    build_number: app_store_build_number + 1,
		    xcodeproj: "Example.xcodeproj"
		  )
		end		 	
	
	对于上述所有步骤，有更多参数可用，请运行以下步骤以获取完整列表
	fastlane action [action_name]
		 	

	
	
	