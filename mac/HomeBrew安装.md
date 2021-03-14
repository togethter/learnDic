###brew command not found报错mac的解决办法

1、换源,然后根据提示操作

	/bin/zsh -c "$(curl -fsSL https://gitee.com/cunkai/HomebrewCN/raw/master/Homebrew.sh)"


2、命令行执行以下命令，不过国内好像有点问题，因为raw.githubusercontent.com这个网站被墙了，无法访问，会出现443的错误，所以建议使用方案1

	/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"