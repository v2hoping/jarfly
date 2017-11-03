## 维护日志

### 2017-11-03

更新:
1. 项目接口和类优化
2. 文件上传明细
3. 进程杀死时间超时限制
4. 杀死进程路径记录，用于之后服务异常回滚

计划:
1. 定义启动超时时间，检查功能
2. 定义Dubbo超时时间，检查功能
3. 超时时间可配置功能
4. 服务异常回滚功能
5. 优化项目结构，将过长的方法拆分和抽象.
6. 增加一Jar多地址发送功能(仅内网传输),考虑先传到一台服务期上，再分别向其余服务器发送.
7. 增强易用性，例如未创建目录应自动创建，而非报错