let htttp404Error   = (404,"Not Found")
print("....\(htttp404Error.0)")

let http200 = (statusCode:200,description:"0k")
print("...\(http200.statusCode)")

let (aa,_) = htttp404Error
print("....\(aa)")
