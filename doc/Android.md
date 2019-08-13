### Gradle 编译方式选择

|  名称 |功能|
|---|---|
|  compile（api） |最常用的方式，使用该方式依赖的库将会参与编译和打包|
|implementation|新增编译方式，添加的依赖，隐藏在模块内部，不对外部模块公开|
|provided（compileOnly）|只在编译时有效，不会参与打包|
|apk（runtimeOnly）|只在生成apk的时候参与打包，编译时不会参与，很少用。|
|testCompile（testImplementation）|只在单元测试代码的编译以及最终打包测试apk时有效。|
|debugCompile（debugImplementation）|只在 debug 模式的编译和最终的 debug apk 打包时有效|
|releaseCompile（releaseImplementation）|仅仅针对 Release 模式的编译和最终的 Release apk 打包。|
