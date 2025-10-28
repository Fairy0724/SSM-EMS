# 员工管理系统（EMS）
员工管理系统（Employee Management System，简称 EMS）是一款面向企业HR、管理人员与普通员工的人力资源管理类项目，专注于实现完整的员工信息管理流程（员工档案维护、部门管理、考勤统计、请假审批）与角色化权限控制（不同岗位对应不同操作权限），适合学习企业内部系统业务逻辑梳理、权限分级及数据关联设计的实践项目。

## 学习目的
1. 掌握企业人力资源核心业务流程设计（员工信息管理、部门与职位关联、考勤与请假流程联动）
2. 学会基于岗位的权限控制实现，区分HR、管理员、部门主管与普通员工的操作边界
3. 理解关系型数据库在企业管理场景的应用（员工-部门-职位多表关联、外键约束设计）
4. 熟悉SSM框架整合开发（Spring MVC请求处理、MyBatis 数据访问、事务管理）
5. 掌握Web项目权限校验与数据校验的实现方式（登录状态维护、表单数据合法性验证）

## 核心技术
- 开发语言：Java
- 数据库：MySQL
- 前端技术：
  - 页面构建：HTML + CSS
  - 交互处理：jQuery + Ajax
  - 布局框架：基于 MetisMenu 的后台布局
- 后端核心：
  - 框架整合：SSM（Spring + Spring MVC + MyBatis）
  - 分层架构：
     - Controller层：处理HTTP请求（如EmployeeController、DepartmentController）
     - Service层：封装业务逻辑（如员工增删改查、考勤统计）
     - DAO层：数据库交互（基于MyBatis Mapper实现CRUD）
  - 分页处理：MyBatis-Plus分页插件
- 安全与权限：
  - 角色控制：区分HR、系统管理员、部门主管、普通员工权限
  - 登录状态：基于HttpSession的用户状态管理


## 功能模块

### 1.  普通员工功能
- 账号管理：登录（工号+密码验证）、个人信息查看与修改（手机号、邮箱、地址等）、退出登录
- 考勤管理：上下班打卡（记录签到 / 签退时间）、查看个人考勤记录（正常/迟到/早退状态）
- 请假管理：提交请假申请（事假/病假，需填写起止时间与原因）、查看个人请假记录及审批状态
- 加班管理：查看个人加班记录（日期、时长等信息）
- 公告查看：浏览系统最新公告（目前隐藏了）

### 2. 部门主管功能
- 基础功能：拥有普通员工的全部操作权限
- 请假审批：查看本部门员工的请假申请，进行 “批准” 或 “驳回” 操作
- 部门考勤查看：查看本部门所有员工的考勤记录（汇总统计与明细）
- 部门员工管理：查看本部门员工基本信息（不含修改权限）

### 3. HR功能
- 员工管理：
  - 员工信息全流程维护（添加、修改、删除员工档案，包含基本信息、所属部门、岗位等）
  - 员工列表分页查询与搜索（支持按姓名模糊查询）
  - 员工在职状态管理（标记离职/退休状态，同步更新档案记录）
- 组织架构管理：
  - 部门管理（新增、编辑、删除部门信息，维护部门编号、负责人、联系方式等）
  - 岗位管理（维护岗位名称、级别及备注信息）
- 考勤与假期管理：
  - 查看全公司员工考勤记录，统计考勤异常情况
  - 管理员工请假记录（查看所有部门请假数据）
- 员工变动管理：记录员工部门/岗位调动历史（包含调动前后信息、操作人及时间）
  
### 4. 系统管理员功能
- 基础功能：拥有HR的全部操作权限
- 系统配置：管理系统基础参数（如考勤时间规则、请假类型配置等）
- 管理员管理：添加、编辑其他管理员账号，分配管理权限（如HR权限授予）
- 数据维护：数据库备份与恢复、系统日志查看（操作记录追溯）
- 
## 成品展示
- 系统登录页：
![系统登录页](https://github.com/Fairy0724/SSM-EMS/blob/master/src/main/webapp/img/screenshot/login.png)
- 主页面：
![系统登录页](https://github.com/Fairy0724/SSM-EMS/blob/master/src/main/webapp/img/screenshot/mainPage.png)
- 员工个人中心：
![员工个人中心](https://github.com/Fairy0724/SSM-EMS/blob/master/src/main/webapp/img/screenshot/departmentList.png)
- 部门列表：
![系统登录页](https://github.com/Fairy0724/SSM-EMS/blob/master/src/main/webapp/img/screenshot/departmentList.png)
- 职位列表：
![系统登录页](https://github.com/Fairy0724/SSM-EMS/blob/master/src/main/webapp/img/screenshot/positionList.png)
- 员工列表：
![系统登录页](https://github.com/Fairy0724/SSM-EMS/blob/master/src/main/webapp/img/screenshot/employeeList.png)
## 快速开始

### 1. 克隆项目
```bash
# 克隆远程仓库到本地
git clone https://github.com/Fairy0724/SSM-EMS.git

# 进入项目目录
cd SSM-EMS
```
### 2. 环境配置
1. 导入数据库脚本：执行ssmhr.sql文件初始化数据库表结构及测试数据（包含部门、岗位、测试员工等基础数据）
2. 配置数据库连接：修改jdbc.properties文件中的数据库地址、用户名及密码
3. 部署项目：通过IDE（如IntelliJ IDEA）配置Tomcat服务器，部署项目WAR包
4. 访问系统：浏览器访问http://localhost:8080/EMS/employee/login.do进入登录页
