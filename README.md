<h1>springmvc+mybatis基础结构项目</h1> 
<p>学习jsp路上自己搞得一个简单项目结构。</p>
<p>适合初学者参考学习</p>
<p>支持log，jstl，tiles</p>
<p>包含一套简单的广告管理增删改查实例。</p>
<p>只为学习参考,初学者可以快速架构出项目，看到成果后更方便学习。</p>
<p>clone 后请用idea 打开项目</p>

<p>mysql 数据库创建命令 CREATE DATABASE `mytest` /*!40100 DEFAULT CHARACTER SET utf8 */</p>
<p>表创建命令：CREATE TABLE `tb_ad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL COMMENT '标题',
  `img_file_name` varchar(100) NOT NULL COMMENT '图片文件名称',
  `link` varchar(200) NOT NULL COMMENT '链接地址',
  `weight` int(11) NOT NULL COMMENT '权重',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8</p>

<p>配合的前端项目https://github.com/zhangxiaotian2s/springMVC_test_vue</p>
