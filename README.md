旅游规划

## JDK环境
**用yum命令安装，这种办法简单粗暴，就像盖伦丢技能一样。废话不多说，直接开始操作。**
1. 首先执行以下命令查看可安装的jdk版本：
`yum -y list java*`
2. 选择你要的版本
`yum install -y java-1.8.0-openjdk-devel.x86_64`
3. 安装完成之后，查看安装的jdk版本，输入以下指令:
`java -version`
就安装成功了，环境变量都不用配置。