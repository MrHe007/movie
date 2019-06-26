/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.14-log : Database - movie
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`movie` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `movie`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `aname` varchar(20) NOT NULL,
  `apassword` varchar(40) NOT NULL,
  `img_url` varchar(60) DEFAULT 'http://t.cn/RCzsdCq',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`aid`,`aname`,`apassword`,`img_url`) values (1,'admin','admin','http://t.cn/RCzsdCq');

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `score` int(11) NOT NULL,
  `content` text NOT NULL,
  `mid` int(11) NOT NULL COMMENT 'movieId',
  `uid` int(11) NOT NULL COMMENT 'userId',
  `time` varchar(30) NOT NULL COMMENT '评论时间',
  `state` int(11) DEFAULT '1' COMMENT '是否禁止这条评论,0 表示不显示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

insert  into `comment`(`id`,`score`,`content`,`mid`,`uid`,`time`,`state`) values (2,9,'hello world1',26100958,2,'1992-9-2',1),(3,9,'hello world2',26100958,2,'1992-9-2',1),(4,9,'hello world3',26100958,2,'1992-9-2',1),(5,9,'hello world4',26100958,2,'1992-9-2',1),(6,9,'hello world5',26100958,2,'1992-9-2',1),(7,9,'hello world6',26100958,2,'1992-9-2',1),(8,9,'hello world7',26100958,2,'1992-9-2',1),(9,9,'hello world8',26100958,2,'1992-9-2',1),(10,9,'hello world9',26100958,2,'1992-9-2',1),(11,9,'hello world10',26100958,2,'1992-9-2',1),(12,9,'hello world11',26100958,2,'1992-9-2',1),(13,9,'hello world12',26100958,2,'1992-9-2',1),(14,9,'hello world13',26100958,2,'1992-9-2',1),(15,9,'hello world14',26100958,2,'1992-9-2',1),(16,9,'hello world15',26100958,2,'1992-9-2',1),(17,9,'hello world16',26100958,2,'1992-9-2',1),(18,9,'hello world17',26100958,2,'1992-9-2',1),(19,9,'hello world18',26100958,2,'1992-9-2',1),(20,9,'hello world19',26100958,2,'1992-9-2',1),(21,9,'hello world20',26100958,2,'1992-9-2',1),(22,9,'hello world21',26100958,2,'1992-9-2',1),(23,9,'hello world22',26100958,2,'1992-9-2',1),(24,9,'hello world23',26100958,2,'1992-9-2',1),(25,9,'hello world24',26100958,2,'1992-9-2',1),(26,9,'hello world25',26100958,2,'1992-9-2',1),(27,9,'hello world26',26100958,2,'1992-9-2',1),(28,9,'hello world27',26100958,2,'1992-9-2',1),(29,9,'hello world28',26100958,2,'1992-9-2',1),(30,9,'hello world29',26100958,2,'1992-9-2',1),(31,9,'hello world30',26100958,2,'1992-9-2',1),(32,9,'hello world31',26100958,2,'1992-9-2',1),(33,9,'hello world32',26100958,2,'1992-9-2',1),(34,9,'hello world33',26100958,2,'1992-9-2',1),(35,9,'hello world34',26100958,2,'1992-9-2',1),(36,9,'hello world35',26100958,2,'1992-9-2',1),(37,9,'hello world36',26100958,2,'1992-9-2',1),(38,9,'hello world37',26100958,2,'1992-9-2',1),(39,9,'hello world38',26100958,2,'1992-9-2',1),(40,9,'hello world39',26100958,2,'1992-9-2',1),(41,9,'hello world40',26100958,2,'1992-9-2',1),(42,9,'hello world41',26100958,2,'1992-9-2',1),(43,9,'hello world42',26100958,2,'1992-9-2',1),(44,9,'hello world43',26100958,2,'1992-9-2',1),(45,9,'hello world44',26100958,2,'1992-9-2',1),(46,9,'hello world45',26100958,2,'1992-9-2',1),(47,9,'hello world46',26100958,2,'1992-9-2',1),(48,9,'hello world47',26100958,2,'1992-9-2',1),(49,9,'hello world48',26100958,2,'1992-9-2',1),(50,9,'hello world49',26100958,2,'1992-9-2',1),(51,9,'hello world50',26100958,2,'1992-9-2',1),(52,9,'hello world51',26100958,2,'1992-9-2',1),(53,9,'hello world52',26100958,2,'1992-9-2',1),(54,9,'hello world53',26100958,2,'1992-9-2',1),(55,9,'hello world54',26100958,2,'1992-9-2',1),(56,9,'hello world55',26100958,2,'1992-9-2',1),(57,9,'hello world56',26100958,2,'1992-9-2',1),(58,9,'hello world57',26100958,2,'1992-9-2',1),(59,9,'hello world58',26100958,2,'1992-9-2',1),(60,9,'hello world59',26100958,2,'1992-9-2',1),(61,9,'hello world60',26100958,2,'1992-9-2',1),(62,9,'hello world61',26100958,2,'1992-9-2',1),(63,9,'hello world62',26100958,2,'1992-9-2',1),(64,9,'hello world63',26100958,2,'1992-9-2',1),(65,9,'hello world64',26100958,2,'1992-9-2',1),(66,9,'hello world65',26100958,2,'1992-9-2',1),(67,9,'hello world66',26100958,2,'1992-9-2',1),(68,9,'hello world67',26100958,2,'1992-9-2',1),(69,9,'hello world68',26100958,2,'1992-9-2',1),(70,9,'hello world69',26100958,2,'1992-9-2',1),(71,9,'hello world70',26100958,2,'1992-9-2',1),(72,9,'hello world71',26100958,2,'1992-9-2',1),(73,9,'hello world72',26100958,2,'1992-9-2',1),(74,9,'hello world73',26100958,2,'1992-9-2',1),(75,9,'hello world74',26100958,2,'1992-9-2',1),(76,9,'hello world75',26100958,2,'1992-9-2',1),(77,9,'hello world76',26100958,2,'1992-9-2',1),(78,9,'hello world77',26100958,2,'1992-9-2',1),(79,9,'hello world78',26100958,2,'1992-9-2',1),(80,9,'hello world79',26100958,2,'1992-9-2',1),(81,9,'hello world80',26100958,2,'1992-9-2',1),(82,9,'hello world81',26100958,2,'1992-9-2',1),(83,9,'hello world82',26100958,2,'1992-9-2',1),(84,9,'hello world83',26100958,2,'1992-9-2',1),(85,9,'hello world84',26100958,2,'1992-9-2',1),(86,9,'hello world85',26100958,2,'1992-9-2',1),(87,9,'hello world86',26100958,2,'1992-9-2',1),(88,9,'hello world87',26100958,2,'1992-9-2',1),(89,9,'hello world88',26100958,2,'1992-9-2',1),(90,9,'hello world89',26100958,2,'1992-9-2',1),(91,9,'hello world90',26100958,2,'1992-9-2',1),(92,9,'hello world91',26100958,2,'1992-9-2',1),(93,9,'hello world92',26100958,2,'1992-9-2',1),(94,9,'hello world93',26100958,2,'1992-9-2',1),(95,9,'hello world94',26100958,2,'1992-9-2',1),(96,9,'hello world95',26100958,2,'1992-9-2',1),(97,9,'hello world96',26100958,2,'1992-9-2',1),(98,9,'hello world97',26100958,2,'1992-9-2',1),(99,9,'hello world98',26100958,2,'1992-9-2',1),(100,9,'hello world99',26100958,2,'1992-9-2',1),(101,8,'好看呀！！',24773958,2,'2019-05-30',1),(102,9,'这部电影好像好阔以撒',26835471,2,'2019-05-30',1);

/*Table structure for table `countries` */

DROP TABLE IF EXISTS `countries`;

CREATE TABLE `countries` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `countries` */

insert  into `countries`(`id`,`name`) values (1,'中国大陆'),(2,'美国'),(3,'香港'),(4,'台湾'),(5,'日本'),(6,'韩国'),(7,'英国'),(8,'法国'),(9,'德国'),(10,'意大利'),(11,'西班牙'),(12,'印度'),(13,'泰国'),(14,'俄罗斯'),(15,'伊朗'),(16,'加拿大'),(17,'澳大利亚'),(18,'爱尔兰'),(19,'瑞典'),(20,'巴西'),(21,'丹麦');

/*Table structure for table `features` */

DROP TABLE IF EXISTS `features`;

CREATE TABLE `features` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `features` */

insert  into `features`(`id`,`name`) values (1,'经典'),(2,'青春'),(3,'文艺'),(4,'搞笑'),(5,'励志'),(6,'魔幻'),(7,'感人'),(8,'女性'),(9,'黑板');

/*Table structure for table `genres` */

DROP TABLE IF EXISTS `genres`;

CREATE TABLE `genres` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `genres` */

insert  into `genres`(`id`,`name`) values (1,'剧情'),(2,'动作'),(3,'爱情'),(4,'科幻'),(5,'动画'),(6,'悬疑'),(7,'惊悚'),(8,'恐怖'),(9,'犯罪'),(10,'同性'),(11,'音乐'),(12,'歌舞'),(13,'传记'),(14,'历史'),(15,'战争'),(16,'西部'),(17,'奇幻'),(18,'冒险'),(19,'灾难'),(20,'武侠'),(21,'情色');

/*Table structure for table `news_item` */

DROP TABLE IF EXISTS `news_item`;

CREATE TABLE `news_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img_url` varchar(160) DEFAULT NULL COMMENT '评论图片地址',
  `title` varchar(30) DEFAULT NULL COMMENT '新闻标题',
  `content` text COMMENT '新闻内容',
  `simple_text` text COMMENT '简短介绍',
  `view_count` int(11) DEFAULT NULL COMMENT '新闻浏览的次数',
  `date` varchar(30) DEFAULT NULL COMMENT '新闻创建的时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

/*Data for the table `news_item` */

insert  into `news_item`(`id`,`img_url`,`title`,`content`,`simple_text`,`view_count`,`date`) values (55,'https://p1.meituan.net/movie/2ea2339d0d30e8472312d04d5ea61055255850.jpg@160w_100h_1e_1c','64岁周润发近照长发变短发，网友：年轻了10岁','hello world','hello',11,'2019-05-19'),(56,'https://p1.meituan.net/movie/2ea2339d0d30e8472312d04d5ea61055255850.jpg@160w_100h_1e_1c','64岁周润发近照长发变短发，网友：年轻了10岁','hello world','hello',11,'2019-05-19'),(57,'https://p0.meituan.net/movie/27d4fb45639e906e1f48c2fbf7f85302991036.jpg@160w_100h_1e_1c','《千与千寻》即将定档，宫崎骏：我的作品为大银幕而做','<p>日前，大师宫崎骏最负盛名作品《千与千寻》宣布内地即将定档！此前影片宣布引进起全民热议，登上微博热搜榜第6位，引进消息单条微博转发超过5万次。作为亚洲唯一一部超越迪士尼、梦工厂力夺奥斯卡金像奖的动画影片，《大圣归来》导演田晓鹏曾说“在宫崎骏面前我是小学生”，蔡康永甚至因为影片“狂哭”。此次内地上映，可谓18年来独一无二的绝佳机会，宫崎骏本人也曾说过“我的作品是为大银幕而创作的”。对于观众来说，无论曾经是否看过，都有充足的理由走进电影院。<br></p><p><b>&nbsp;</b></p><p><b></b></p><p><b></b></p><p><b></b></p><p><b><img src=\"https://p0.meituan.net/movie/a2a5dcf51e083ad0eb42ab10353f4b70778062.jpg@750w_1l\"></b></p><p></p><p><b><br></b></p><p><b>影响迪士尼的传奇大师&nbsp;网友：长大后再看千寻泪流满面</b><br></p><p><b><br></b></p><p>作为动画“巨匠”宫崎骏最出名的作品之一，无论之前是否看过影片，观众都有充足的理由去电影院观看欣赏。</p><p>&nbsp;</p><p>一方面，对于尚未看过的国内观众而言，这是一次“遇见经典”的机会。首先，影片本身就是一部高质量佳作。它在与迪士尼和二十世纪福斯的多部优秀影片竞争中，力夺当年第75界奥斯卡金像奖最佳长篇动画的殊荣。其次，宫崎骏的作品的感染力十足。就连迪士尼动画工作室首席创意官约翰·拉塞特也是宫崎骏的“粉丝”，年少时被被他的作品鼓励后，才制作了《玩具总动员》等老少咸宜的作品。</p><p>&nbsp;</p><p>另一方面，对于已经看过的观众来说，影片登上大银幕更是重新认识作品的绝佳机会。首先，宫崎骏曾表示，“我的作品是为大银幕而创作的”。宫崎骏的作品一向以细节精致而闻名，他甚至不惜花费1年时间，只为能完美描绘4秒的画面。而此次引进，则为观众提供了到电影院“沉浸式体验”的机会。同时，影片具有深刻的现实意义。孩童时期观看时，大多只注意到多彩的世界和冒险的故事，只有长大后再次观看，才能理解其中深意。有观众表示，“小时候只觉得好看，长大后看得泪流满面”。</p><p>&nbsp;</p><p><img src=\"https://p0.meituan.net/movie/a97f902d4ca192679e4fb27c1bcd9fe0743349.jpg@750w_1l\"></p><p><br></p><p><b>首登内地引发</b><b>“千寻效应”&nbsp;</b><b>《大圣归来》导演：我在宫崎骏面前是小学生</b><b>&nbsp;</b><br></p><p><b><br></b></p><p>影片上映十八年来感动无数国内外观众，此次首登内地大银幕，更是在网络上掀起极强的“千寻效应”。此前引进消息公布后，关键词“千与千寻引进中国”荣登微博热搜榜第6名，引进消息单条转发超过5万次，百余个百万量级媒体表示支持。</p><p>&nbsp;</p><p>影片在国内被称为“影响了一代人的电影作品”，其文化价值之高让国内许多影视从业者都倾情推荐。动画领域中，电影《大护法》导演不思凡曾表示“《千与千寻》是所有电影中他最喜欢的作品”。《大圣归来》的导演田晓鹏甚至说“在宫崎骏面前我只是个小学生”；同时，许多明星也是影片的狂热爱好者。蔡康永曾说，“宫崎骏的作品我会因为《千与千寻》哭，尤其是白龙回想起自己名字的片段，每次想到都会狂哭”。王源、迪丽热巴、华晨宇等知名艺人，也都曾公开表示过对于影片的支持与喜爱。</p><p>&nbsp;</p><p>电影《千与千寻》即将登陆中国大陆院线。</p>','日前，大师宫崎骏最负盛名作品《千与千寻》宣布内地即将定档！此前影片宣布引进起全民热议，登上微博热搜榜第6位，引进消息单条微博转发超过5万次。作为亚洲唯一一部超越迪士尼、梦工厂力夺奥斯卡金像奖的动画影片，《大圣归来》导演田晓鹏曾说“在宫崎骏面前我是小学生”，蔡康永甚至因为影片“狂哭”。此次内地上映，可谓18年来独一无二的绝佳机会，宫崎骏本人也曾说过“我的作品是为大银幕而创作的”。对于观众来说，无论曾经是否看过，都有充足的理由走进电影院。&nbsp;影响迪士尼的传奇大师&nbsp;网友：长大后再看千寻泪流满面作为动画“巨匠”宫崎骏最出名的作品之一，无论之前是否看过影片，观众都有充足的理由去电影院观看欣赏。&nbsp;一方面，对于尚未看过的国内观众而言，这是一次“遇见经典”的机会。首先，影片本身就是一部高质量佳作。它在与迪士尼和二十世纪福斯的多部优秀影片竞争中，力夺当年第75界奥斯卡金像奖最佳长篇动画的殊荣。其次，宫崎骏的作品的感染力十足。就连迪士尼动画工作室首席创意官约翰·拉塞特也是宫崎骏的“粉丝”，年少时被被他的作品鼓励后，才制作了《玩具总动员》等老少咸宜的作品。&nbsp;另一方面，对于已经看过的观众来说，影片登上大银幕更是重新认识作品的绝佳机会。首先，宫崎骏曾表示，“我的作品是为大银幕而创作的”。宫崎骏的作品一向以细节精致而闻名，他甚至不惜花费1年时间，只为能完美描绘4秒的画面。而此次引进，则为观众提供了到电影院“沉浸式体验”的机会。同时，影片具有深刻的现实意义。孩童时期观看时，大多只注意到多彩的世界和冒险的故事，只有长大后再次观看，才能理解其中深意。有观众表示，“小时候只觉得好看，长大后看得泪流满面”。&nbsp;首登内地引发“千寻效应”&nbsp;《大圣归来》导演：我在宫崎骏面前是小学生&nbsp;影片上映十八年来感动无数国内外观众，此次首登内地大银幕，更是在网络上掀起极强的“千寻效应”。此前引进消息公布后，关键词“千与千寻引进中国”荣登微博热搜榜第6名，引进消息单条转发超过5万次，百余个百万量级媒体表示支持。&nbsp;影片在国内被称为“影响了一代人的电影作品”，其文化价值之高让国内许多影视从业者都倾情推荐。动画领域中，电影《大护法》导演不思凡曾表示“《千与千寻》是所有电影中他最喜欢的作品”。《大圣归来》的导演田晓鹏甚至说“在宫崎骏面前我只是个小学生”；同时，许多明星也是影片的狂热爱好者。蔡康永曾说，“宫崎骏的作品我会因为《千与千寻》哭，尤其是白龙回想起自己名字的片段，每次想到都会狂哭”。王源、迪丽热巴、华晨宇等知名艺人，也都曾公开表示过对于影片的支持与喜爱。&nbsp;电影《千与千寻》即将登陆中国大陆院线。',NULL,'2019-05-20'),(58,'https://p0.meituan.net/movie/8f30988a5e056cf19d597fc2b9ad4fac102975.jpg@160w_100h_1e_1c','《哥斯拉2：怪兽之王》“口碑燃炸”特辑，百城千场点映超前来袭','<p>由传奇影业、华纳兄弟影片公司、华桦文化联合打造的好莱坞科幻灾难动作巨制、“怪兽宇宙”系列电影第三部力作《哥斯拉2：怪兽之王》将于5月31日全国上映，近日影片举行了盛大的中国首映礼，最新曝光的“口碑燃炸”特辑真实记录了首批中国观众的嗨爽观影感受。“燃炸”“震撼”“非常好看”“必须要去大银幕看”成为观众们的一致感受，更有不少观众给出120分的超高评价！好口碑也让观众更加急迫地想要看到这部年度巨制。日前影片宣布将于5月25日、26日（周六、周日）提前一周开启百城千场超前点映活动，赶快抢票，第一时间见证怪兽史诗之战！<br></p><p><br></p><p><iframe width=\"100%\" height=\"259\" frameborder=\"0\" allowfullscreen=\"\" scrolling=\"no\" src=\"https://m.maoyan.com/player/video?_v_=yes&amp;type=1&amp;id=98996\"></iframe></p><p></p><p><img src=\"https://p0.meituan.net/movie/e3cfebb5a9212bacb4b3d330cf19863d93047.jpg@750w_1l\"></p><p><b><br></b></p><p><b>集体看嗨！怪兽“神仙打架”征服国内观众</b></p><p>&nbsp; &nbsp; &nbsp; 作为2019年度大银幕必看巨制，《哥斯拉2：怪兽之王》备受观众期待。中国首映礼结束后，第一批观众果然得到了极大的满足，“嗨”“爽”“炸”“震撼”成为所有观众的一致观感，不少人打出满分甚至120分的超高分数，更有人直言影片堪称“怪兽片的新高峰”，是怪兽版的“复仇者联盟”。史诗级的“神仙打架”震天撼地，尤其是哥斯拉与三头王者基多拉的巅峰对决令观众意犹未尽，纷纷直呼“上映之后要二刷！”哥斯拉的王者风范、三头王者基多拉的强大攻击力和摩斯拉的美轮美奂也都给观众留下了深刻的印象。大家还呼吁观众一定要去最大的银幕上观看这部电影，相信一定会是一次前所未有的视觉大奇观！</p><p><br></p><p><img src=\"https://p0.meituan.net/movie/8202fea0c200ce55918c2299fde8c7cd116403.jpg@750w_1l\"></p><p><b><br></b></p><p><b>提前观战！百城千场点映周末震撼来袭</b></p><p>&nbsp; &nbsp; &nbsp; 超高口碑也让观众们对影片充满期待。在国内的票务网站数据中，《哥斯拉2：怪兽之王》已经雄踞最受期待榜NO.1，绝对的年度必看！对于按捺不住内心激动的观众，影片再次送上惊喜重磅消息：5月25日（周六）、26日（周日），影片将提前公映日一周的时间，在国内举行百城千场的超大规模点映活动。届时，北京、上海、深圳、广州、成都、重庆、武汉、杭州、苏州、南京等全国101个城市将率先放映《哥斯拉2：怪兽之王》，大家将领先全球观众，一睹怪兽界“四大天王”史诗开战的震撼场面。目前影片的预售已经全面开启，抓紧时间抢票锁定点映场座位，感受极致嗨爽的视觉盛宴。</p><p><br></p><p><img src=\"https://p0.meituan.net/movie/d90e59db811013ce5aacb0df27cc178f117629.jpg@750w_1l\"></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>《哥斯拉2：怪兽之王》由传奇影业、华纳兄弟影片公司、华桦文化联合出品，迈克尔·道赫蒂执导，凯尔·钱德勒、维拉·法梅加、米莉·博比·布朗、布莱德利·惠特福德、莎莉·霍金斯、查里斯·丹斯、托马斯·米德迪奇、小奥谢拉·杰克逊等联袂出演，渡边谦、章子怡特别加盟，将于5月31日同步北美在全国上映。全国预售已开启，赶紧抢票锁定影院C位！</p><p><br></p><p><img src=\"https://p0.meituan.net/movie/2afddbd58d448917c2717defb7c5f7d783120.jpg@750w_1l\"></p>','由传奇影业、华纳兄弟影片公司、华桦文化联合打造的好莱坞科幻灾难动作巨制、“怪兽宇宙”系列电影第三部力作《哥斯拉2：怪兽之王》将于5月31日全国上映，近日影片举行了盛大的中国首映礼，最新曝光的“口碑燃炸”特辑真实记录了首批中国观众的嗨爽观影感受。“燃炸”“震撼”“非常好看”“必须要去大银幕看”成为观众们的一致感受，更有不少观众给出120分的超高评价！好口碑也让观众更加急迫地想要看到这部年度巨制。日前影片宣布将于5月25日、26日（周六、周日）提前一周开启百城千场超前点映活动，赶快抢票，第一时间见证怪兽史诗之战！集体看嗨！怪兽“神仙打架”征服国内观众&nbsp; &nbsp; &nbsp; 作为2019年度大银幕必看巨制，《哥斯拉2：怪兽之王》备受观众期待。中国首映礼结束后，第一批观众果然得到了极大的满足，“嗨”“爽”“炸”“震撼”成为所有观众的一致观感，不少人打出满分甚至120分的超高分数，更有人直言影片堪称“怪兽片的新高峰”，是怪兽版的“复仇者联盟”。史诗级的“神仙打架”震天撼地，尤其是哥斯拉与三头王者基多拉的巅峰对决令观众意犹未尽，纷纷直呼“上映之后要二刷！”哥斯拉的王者风范、三头王者基多拉的强大攻击力和摩斯拉的美轮美奂也都给观众留下了深刻的印象。大家还呼吁观众一定要去最大的银幕上观看这部电影，相信一定会是一次前所未有的视觉大奇观！提前观战！百城千场点映周末震撼来袭&nbsp; &nbsp; &nbsp; 超高口碑也让观众们对影片充满期待。在国内的票务网站数据中，《哥斯拉2：怪兽之王》已经雄踞最受期待榜NO.1，绝对的年度必看！对于按捺不住内心激动的观众，影片再次送上惊喜重磅消息：5月25日（周六）、26日（周日），影片将提前公映日一周的时间，在国内举行百城千场的超大规模点映活动。届时，北京、上海、深圳、广州、成都、重庆、武汉、杭州、苏州、南京等全国101个城市将率先放映《哥斯拉2：怪兽之王》，大家将领先全球观众，一睹怪兽界“四大天王”史诗开战的震撼场面。目前影片的预售已经全面开启，抓紧时间抢票锁定点映场座位，感受极致嗨爽的视觉盛宴。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;《哥斯拉2：怪兽之王》由传奇影业、华纳兄弟影片公司、华桦文化联合出品，迈克尔·道赫蒂执导，凯尔·钱德勒、维拉·法梅加、米莉·博比·布朗、布莱德利·惠特福德、莎莉·霍金斯、查里斯·丹斯、托马斯·米德迪奇、小奥谢拉·杰克逊等联袂出演，渡边谦、章子怡特别加盟，将于5月31日同步北美在全国上映。全国预售已开启，赶紧抢票锁定影院C位！',NULL,'2019-05-20'),(59,'https://p0.meituan.net/movie/f7d88332179a8201818ab11fc9697c5d1051667.png@160w_100h_1e_1c','郎朗“吹不响”龚琳娜“忐忑”，千年古乐器尺八引爆B站','<div><p>近日，一则郎朗“尬吹”的视频引发了B站弹幕热议，视频中，“钢琴王子”郎朗在日本著名尺八演奏家、作曲家佐藤康夫的指导下，试图吹响号称史上最难吹的乐器尺八，可这位音乐天才屡次尝试均告失败，最后勉强吹响了一声，竟开心不已。挑战尺八失败后的郎朗，一脸呆萌地露出苦笑，网友不禁打趣道：“郎朗实在是太可爱了。”</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 最后，郎朗拿出看家绝活，与佐藤康夫来了一段“钢琴加尺八”的即兴合奏，网友瞬间沦陷，纷纷表示“神仙组合，我哭了” “这声音，让人起鸡皮疙瘩。”尤其是佐藤康夫吹奏的尺八因并不为大众所熟知，引发大量讨论，郎朗也对尺八这个传统乐器称赞有加。&nbsp;</p><p><br></p><p><img src=\"https://p1.meituan.net/movie/804812be993885c4c1b40b87e3f7a2211276116.png@750w_1l\"></p><p><img src=\"https://p0.meituan.net/movie/16f6dcc6f28c3e397153e316925cdc301181315.png@750w_1l\"></p><p><br></p><p>千年古乐器尺八走红B站&nbsp;</p><p>UP主各显其能花样演绎《一声一世》&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 除了和郎朗合奏以外，在另一则视频中，佐藤康夫还和龚琳娜进行了音乐上的交流，谈到兴起，龚琳娜在佐藤康夫等众人面前旁若无人地清唱了一曲《忐忑》。网友发弹幕说：“这么近距离听艺术家清唱，好幸福！”“被国家队征服！”一曲唱罢，坐在对面的佐藤康夫送出了钦佩的掌声。&nbsp;</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; “尺八一声一世，让传统拥有姓名”为主题的二创活动在B站得到了大批UP主的自发支持，为了让源于中国的千年古乐器尺八被更多人知道，他们用填词翻唱，影视混剪，改编演奏等方式重新创作佐藤康夫原创尺八曲目《一声一世》。&nbsp;</p><p><br></p><p><img src=\"https://p0.meituan.net/movie/1ed50bd0a76f93eae303027cf9b7d3313028914.png@750w_1l\"></p><p><br></p><p>佐藤康夫是谁？尺八是什么？</p><p>《火影忍者》主题音乐创作者打破次元壁</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 说到佐藤康夫这个名字，你可能并不太熟悉，但说起《火影忍者》，相信你一定耳熟能详了。《火影忍者》里那段经典的主题音乐，就是由佐藤康夫创作并用尺八演奏的。此次来华，佐藤康夫是为了宣传自己主演的音乐人文纪录电影《尺八·一声一世》。他说，1500年前，尺八从中国传到了日本，而他这次前来，是把1500年的历史又带回到中国，并且希望中国的年轻人能够学习传统乐器。</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 令佐藤康夫为之痴迷的尺八，是中国传统吹奏乐器，因其一尺八寸的管长而得名，隋唐时期是宫廷乐器，后随佛教文化一同传入日本。尺八以竹根制作而成，音色浑厚悠远，又极具穿透力。吹奏尺八的难度很高，仅仅是吹响都需要掌握独特的气息控制技巧。而且，尺八的制作条件也很苛刻，因为找到适合制作尺八的竹子就是一件困难的事情，可谓“百竹之林，难寻一支”，专业的尺八制管师则说，也许十万支竹子里，才有那么几根能够做成尺八。即便是找到了合适的竹子，还要经过三五年的存放处理，再经过匠人们反复的手工雕琢、打磨、调音等复杂工序后，才能制作出一支可供演奏的尺八。难做、难吹，可以说是尺八的两个特点，也是尺八在传播上遇到的最大障碍。</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 佐藤康夫一心钻研尺八，他为《火影忍者》创作的主题音乐，不仅是尺八与摇滚乐的巧妙融合，也打通了传统乐器与二次元动漫两个领域。除《火影忍者》外，《阴阳师》等影视动漫的配乐中，也使用了尺八，让人们认识了尺八这个小众的神乐器。2018年，佐藤康夫曾经带着火的意志乐队来到中国演出，除演奏了多首《火影忍者》经典曲目外，还演奏了他为歌舞伎《阴阳师》谱写的《夜明》，不仅让台下的观众听得入神，也引发了大家对于尺八传承的忧虑，这样美妙的乐器竟然不为大众熟知？&nbsp;</p><p><img src=\"https://p0.meituan.net/movie/7f774f4fecae190fa25d285c7ebb096f1866753.png@750w_1l\"></p><p><br></p><p>《尺八·一声一世》揭秘中国传统神乐器</p><p>聿馨导演历时三年重现尺八之美&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 《尺八·一声一世》就试图带着大家认识尺八，展现尺八的历史、底蕴与独特的美感，让这个中国传统的乐器能够重回大众视野。《尺八·一声一世》是聿馨导演历时三年拍摄的音乐人文纪录电影，除了佐藤康夫以外，影片还记录了中、日、美等地的尺八演奏家、制管师以及学习者的生活，讲出了一段又一段关于尺八的故事。既有世代传承的“尺八世家”，也有偶然间结实尺八后便毅然修行的“尺八习者”，他们因为对于尺八的热爱，而选择了心之向往的另一种生活，在各自的路上，演绎着生命与音乐的动人交响。</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 尺八就像人，每一支都是独一无二的，每一支也都有自己的样子和性格。《尺八·一声一世》中，佐藤康夫由衷地说道： “用　‘一音’将人心中的迷茫与悲伤进行救赎，我一直想成为这样的音乐家。我想走出自己的路。”</p><p><br></p><p><img src=\"https://p1.meituan.net/movie/ba4a5204fa4828e09a01892160b06a98293111.jpg@750w_1l\"></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p><p>&nbsp;和钢琴、吉他等大众流行的乐器相比，选择尺八，就是选择了一条孤独的音乐之路，就像影片中的蔡鸿文，作为中国唯一专业院校的尺八教师，他并非音乐人出身，但被尺八吸引后，便抛弃了此前安逸的生活，像一个音乐行者，此生要与尺八为伴。佐藤康夫也是这样，他不断地练习、不断地创作、不断地寻找自己与尺八相融的感觉。他们也许是孤独的，但也是幸福的，因为他们做到了“不枉此声，不负所爱”，这也就是影片想要传递出的“一声一世”的真正含义。</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 佐藤康夫不仅主演了《尺八·一声一世》，也担任了影片的音乐监制及尺八演奏者。这部能让你在电影院中大饱耳福的音乐人文纪录电影由上海天人慧致文化传播有限公司制作出品，聿馨执导，佐藤康夫、小凑昭尚、蔡鸿文等主演，梁文道、陆川、龚琳娜特别出演。《尺八·一声一世》将于5月31日正式登陆全国各大院线。</p><p><br></p><p><img src=\"https://p0.meituan.net/movie/9d0e8595998e6ccf7d26e81c6c59cd94286387.jpg@750w_1l\"></p></div><div>&nbsp;&nbsp;&nbsp;赞&nbsp;<div><div>&nbsp;&nbsp;分 享</div></div></div>','近日，一则郎朗“尬吹”的视频引发了B站弹幕热议，视频中，“钢琴王子”郎朗在日本著名尺八演奏家、作曲家佐藤康夫的指导下，试图吹响号称史上最难吹的乐器尺八，可这位音乐天才屡次尝试均告失败，最后勉强吹响了一声，竟开心不已。挑战尺八失败后的郎朗，一脸呆萌地露出苦笑，网友不禁打趣道：“郎朗实在是太可爱了。”&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 最后，郎朗拿出看家绝活，与佐藤康夫来了一段“钢琴加尺八”的即兴合奏，网友瞬间沦陷，纷纷表示“神仙组合，我哭了” “这声音，让人起鸡皮疙瘩。”尤其是佐藤康夫吹奏的尺八因并不为大众所熟知，引发大量讨论，郎朗也对尺八这个传统乐器称赞有加。&nbsp;千年古乐器尺八走红B站&nbsp;UP主各显其能花样演绎《一声一世》&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 除了和郎朗合奏以外，在另一则视频中，佐藤康夫还和龚琳娜进行了音乐上的交流，谈到兴起，龚琳娜在佐藤康夫等众人面前旁若无人地清唱了一曲《忐忑》。网友发弹幕说：“这么近距离听艺术家清唱，好幸福！”“被国家队征服！”一曲唱罢，坐在对面的佐藤康夫送出了钦佩的掌声。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; “尺八一声一世，让传统拥有姓名”为主题的二创活动在B站得到了大批UP主的自发支持，为了让源于中国的千年古乐器尺八被更多人知道，他们用填词翻唱，影视混剪，改编演奏等方式重新创作佐藤康夫原创尺八曲目《一声一世》。&nbsp;佐藤康夫是谁？尺八是什么？《火影忍者》主题音乐创作者打破次元壁&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 说到佐藤康夫这个名字，你可能并不太熟悉，但说起《火影忍者》，相信你一定耳熟能详了。《火影忍者》里那段经典的主题音乐，就是由佐藤康夫创作并用尺八演奏的。此次来华，佐藤康夫是为了宣传自己主演的音乐人文纪录电影《尺八·一声一世》。他说，1500年前，尺八从中国传到了日本，而他这次前来，是把1500年的历史又带回到中国，并且希望中国的年轻人能够学习传统乐器。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 令佐藤康夫为之痴迷的尺八，是中国传统吹奏乐器，因其一尺八寸的管长而得名，隋唐时期是宫廷乐器，后随佛教文化一同传入日本。尺八以竹根制作而成，音色浑厚悠远，又极具穿透力。吹奏尺八的难度很高，仅仅是吹响都需要掌握独特的气息控制技巧。而且，尺八的制作条件也很苛刻，因为找到适合制作尺八的竹子就是一件困难的事情，可谓“百竹之林，难寻一支”，专业的尺八制管师则说，也许十万支竹子里，才有那么几根能够做成尺八。即便是找到了合适的竹子，还要经过三五年的存放处理，再经过匠人们反复的手工雕琢、打磨、调音等复杂工序后，才能制作出一支可供演奏的尺八。难做、难吹，可以说是尺八的两个特点，也是尺八在传播上遇到的最大障碍。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 佐藤康夫一心钻研尺八，他为《火影忍者》创作的主题音乐，不仅是尺八与摇滚乐的巧妙融合，也打通了传统乐器与二次元动漫两个领域。除《火影忍者》外，《阴阳师》等影视动漫的配乐中，也使用了尺八，让人们认识了尺八这个小众的神乐器。2018年，佐藤康夫曾经带着火的意志乐队来到中国演出，除演奏了多首《火影忍者》经典曲目外，还演奏了他为歌舞伎《阴阳师》谱写的《夜明》，不仅让台下的观众听得入神，也引发了大家对于尺八传承的忧虑，这样美妙的乐器竟然不为大众熟知？&nbsp;《尺八·一声一世》揭秘中国传统神乐器聿馨导演历时三年重现尺八之美&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 《尺八·一声一世》就试图带着大家认识尺八，展现尺八的历史、底蕴与独特的美感，让这个中国传统的乐器能够重回大众视野。《尺八·一声一世》是聿馨导演历时三年拍摄的音乐人文纪录电影，除了佐藤康夫以外，影片还记录了中、日、美等地的尺八演奏家、制管师以及学习者的生活，讲出了一段又一段关于尺八的故事。既有世代传承的“尺八世家”，也有偶然间结实尺八后便毅然修行的“尺八习者”，他们因为对于尺八的热爱，而选择了心之向往的另一种生活，在各自的路上，演绎着生命与音乐的动人交响。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 尺八就像人，每一支都是独一无二的，每一支也都有自己的样子和性格。《尺八·一声一世》中，佐藤康夫由衷地说道： “用　‘一音’将人心中的迷茫与悲伤进行救赎，我一直想成为这样的音乐家。我想走出自己的路。”&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;和钢琴、吉他等大众流行的乐器相比，选择尺八，就是选择了一条孤独的音乐之路，就像影片中的蔡鸿文，作为中国唯一专业院校的尺八教师，他并非音乐人出身，但被尺八吸引后，便抛弃了此前安逸的生活，像一个音乐行者，此生要与尺八为伴。佐藤康夫也是这样，他不断地练习、不断地创作、不断地寻找自己与尺八相融的感觉。他们也许是孤独的，但也是幸福的，因为他们做到了“不枉此声，不负所爱”，这也就是影片想要传递出的“一声一世”的真正含义。&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 佐藤康夫不仅主演了《尺八·一声一世》，也担任了影片的音乐监制及尺八演奏者。这部能让你在电影院中大饱耳福的音乐人文纪录电影由上海天人慧致文化传播有限公司制作出品，聿馨执导，佐藤康夫、小凑昭尚、蔡鸿文等主演，梁文道、陆川、龚琳娜特别出演。《尺八·一声一世》将于5月31日正式登陆全国各大院线。&nbsp;&nbsp;&nbsp;赞&nbsp;&nbsp;&nbsp;分 享',NULL,'2019-05-20'),(62,'https://p0.meituan.net/movie/600e0015dfe8f5b542a5b73325be23ee817791.jpg@160w_100h_1e_1c','《X战警：黑凤凰》全新预告杀意尽显，“鲨美”神仙组合伦敦合体','<p>由美国二十世纪福斯公司出品，美国漫威影业公司联合出品的超级英雄大片《X战警：黑凤凰》将于6月6日登陆全国院线，目前，上海、广州、深圳、成都、南京等热门城市预售已陆续开启。今日片方发布“杀气爆发”版预告，凤凰黑化与X战警正面对抗，全体变种人危机降临。此外，主创“一美”詹姆斯·麦卡沃伊、“法鲨”迈克尔·法斯宾德、“凤凰女”苏菲·特纳、“劳模姐”杰西卡·查斯坦和导演西蒙·金伯格已悉数抵达伦敦，掀起新一轮X战警热潮。<br></p><p><br></p><p><iframe width=\"100%\" height=\"259\" frameborder=\"0\" allowfullscreen=\"\" scrolling=\"no\" src=\"https://m.maoyan.com/player/video?_v_=yes&amp;type=1&amp;id=98939\"></iframe></p><p></p><p></p><p><img src=\"https://p0.meituan.net/movie/2ee15414320b7642284dd9d07fc77be1281203.jpg@750w_1l\"></p><p></p><p><br></p><p>在最新预告中，愤怒和激情让凤凰女琴·葛蕾的力量越变越强，无法控制的力量也让她逐渐黑化，与其他X战警分裂对抗。饰演X教授的詹姆斯·麦卡沃伊曾表示，“（X战警）就像是一个大家庭一样”，然而在这部影片中，导演西蒙·金伯格创造出更紧张、更情绪化的戏剧冲突——曾经并肩作战的家人分崩离析，面临“人性”的拷问，X战警的情感抉择牵动着每一个观众的心。而在凤凰之力的绝对压制和外星势力入侵的阴霾笼罩下，紧张感充斥着整个X宇宙。</p><p><br></p><p><img src=\"https://p0.meituan.net/movie/f70550f3feaf6a44592ddbb736b5c2911554586.jpg@750w_1l\"></p><p><img src=\"https://p0.meituan.net/movie/bc3988264ab8a6eb7d67c59856ea1b24110017.jpg@750w_1l\"></p><p><br></p><p>电影上映在即，作为《X战警》系列20年来最高潮之作，备受粉丝喜爱的次代阵容继续在全球开启宣传旅程。詹姆斯·麦卡沃伊、迈克尔·法斯宾德、苏菲·特纳和新加盟的杰西卡·查斯坦现身伦敦市中心，高颜值合影堪比时尚大片。而这几位主要演员的聚首也令粉丝们纷纷高呼“神仙组合”、“超级期待影片中四人组碰撞出的火花。”</p><p><br></p><p><img src=\"https://p0.meituan.net/movie/51e9270af1e5cc1adf6d3632b7bca502401975.jpg@750w_1l\"></p><p><img src=\"https://p0.meituan.net/movie/118466f2adf0719d09fc52c5227aaf02164957.jpg@750w_1l\"></p><p><br></p><p>在伦敦宣传过程中，詹姆斯·麦卡沃伊和迈克尔·法斯宾德还合体接受了采访，现场揭秘影片背后的故事，引发粉丝们对电影剧情的强烈期待。饰演X教授的詹姆斯·麦卡沃伊表示，“这部电影的有趣之处在于，我们处理矛盾的过程有真正能让人们产生共鸣的地方”，而迈克尔·法斯宾德不仅提到万磁王与快银的父子关系，表示正在“互相了解对方”，还现场爆料，直言“艾瑞克很孤独，但查尔斯是他永远的朋友”，“鲨美”版EC在影片中将会有怎样全新“相爱相杀”的戏码，可谓值得期待。</p><p><br></p><p></p><p><img src=\"https://p0.meituan.net/movie/2a06493bd3ae51cfab1bbc512aa406d8412174.jpg@750w_1l\"></p>','由美国二十世纪福斯公司出品，美国漫威影业公司联合出品的超级英雄大片《X战警：黑凤凰》将于6月6日登陆全国院线，目前，上海、广州、深圳、成都、南京等热门城市预售已陆续开启。今日片方发布“杀气爆发”版预告，凤凰黑化与X战警正面对抗，全体变种人危机降临。此外，主创“一美”詹姆斯·麦卡沃伊、“法鲨”迈克尔·法斯宾德、“凤凰女”苏菲·特纳、“劳模姐”杰西卡·查斯坦和导演西蒙·金伯格已悉数抵达伦敦，掀起新一轮X战警热潮。在最新预告中，愤怒和激情让凤凰女琴·葛蕾的力量越变越强，无法控制的力量也让她逐渐黑化，与其他X战警分裂对抗。饰演X教授的詹姆斯·麦卡沃伊曾表示，“（X战警）就像是一个大家庭一样”，然而在这部影片中，导演西蒙·金伯格创造出更紧张、更情绪化的戏剧冲突——曾经并肩作战的家人分崩离析，面临“人性”的拷问，X战警的情感抉择牵动着每一个观众的心。而在凤凰之力的绝对压制和外星势力入侵的阴霾笼罩下，紧张感充斥着整个X宇宙。电影上映在即，作为《X战警》系列20年来最高潮之作，备受粉丝喜爱的次代阵容继续在全球开启宣传旅程。詹姆斯·麦卡沃伊、迈克尔·法斯宾德、苏菲·特纳和新加盟的杰西卡·查斯坦现身伦敦市中心，高颜值合影堪比时尚大片。而这几位主要演员的聚首也令粉丝们纷纷高呼“神仙组合”、“超级期待影片中四人组碰撞出的火花。”在伦敦宣传过程中，詹姆斯·麦卡沃伊和迈克尔·法斯宾德还合体接受了采访，现场揭秘影片背后的故事，引发粉丝们对电影剧情的强烈期待。饰演X教授的詹姆斯·麦卡沃伊表示，“这部电影的有趣之处在于，我们处理矛盾的过程有真正能让人们产生共鸣的地方”，而迈克尔·法斯宾德不仅提到万磁王与快银的父子关系，表示正在“互相了解对方”，还现场爆料，直言“艾瑞克很孤独，但查尔斯是他永远的朋友”，“鲨美”版EC在影片中将会有怎样全新“相爱相杀”的戏码，可谓值得期待。',NULL,'2019-05-23');

/*Table structure for table `tb_movie` */

DROP TABLE IF EXISTS `tb_movie`;

CREATE TABLE `tb_movie` (
  `mid` int(11) NOT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_movie` */

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `imgUrl` varchar(100) DEFAULT 'http://t.cn/RCzsdCq' COMMENT '用户头像',
  `phone` varchar(15) DEFAULT NULL COMMENT '用户联系方式',
  `birthday` varchar(30) DEFAULT NULL COMMENT '出生生日',
  `state` tinyint(1) DEFAULT '1' COMMENT '用户是否允许登入',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `unique_key` (`username`,`email`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`uid`,`username`,`password`,`email`,`imgUrl`,`phone`,`birthday`,`state`) values (2,'hechen','admin','hechen@163.com','/upload/imgs/u=3147328226,3569316785&fm=26&gp=0.jpg','15570990166','1997-9-9',1),(3,'bigguy','bigguy','bigguy@163.com','http://t.cn/RCzsdCq','15570990166','1998-9-3',1),(4,'赵云','zhaoyun','zhaoyun@163.com','http://t.cn/RCzsdCq','15570990166','1999-9-2',1),(5,'bigguy0','bigguy0','bigguy0@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(6,'bigguy1','bigguy1','bigguy1@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(7,'bigguy2','bigguy2','bigguy2@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(8,'bigguy3','bigguy3','bigguy3@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(9,'bigguy4','bigguy4','bigguy4@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(10,'bigguy5','bigguy5','bigguy5@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(11,'bigguy6','bigguy6','bigguy6@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(12,'bigguy7','bigguy7','bigguy7@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(13,'bigguy8','bigguy8','bigguy8@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(14,'bigguy9','bigguy9','bigguy9@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(15,'bigguy10','bigguy10','bigguy10@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(16,'bigguy11','bigguy11','bigguy11@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(17,'bigguy12','bigguy12','bigguy12@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(18,'bigguy13','bigguy13','bigguy13@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(19,'bigguy14','bigguy14','bigguy14@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(20,'bigguy15','bigguy15','bigguy15@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(21,'bigguy16','bigguy16','bigguy16@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(22,'bigguy17','bigguy17','bigguy17@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(23,'bigguy18','bigguy18','bigguy18@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(24,'bigguy19','bigguy19','bigguy19@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(25,'bigguy20','bigguy20','bigguy20@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(26,'bigguy21','bigguy21','bigguy21@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(27,'bigguy22','bigguy22','bigguy22@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(28,'bigguy23','bigguy23','bigguy23@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(29,'bigguy24','bigguy24','bigguy24@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(30,'bigguy25','bigguy25','bigguy25@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(31,'bigguy26','bigguy26','bigguy26@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(32,'bigguy27','bigguy27','bigguy27@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(33,'bigguy28','bigguy28','bigguy28@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(34,'bigguy29','bigguy29','bigguy29@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(35,'bigguy30','bigguy30','bigguy30@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(36,'bigguy31','bigguy31','bigguy31@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(37,'bigguy32','bigguy32','bigguy32@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(38,'bigguy33','bigguy33','bigguy33@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(39,'bigguy34','bigguy34','bigguy34@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(40,'bigguy35','bigguy35','bigguy35@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(41,'bigguy36','bigguy36','bigguy36@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(42,'bigguy37','bigguy37','bigguy37@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(43,'bigguy38','bigguy38','bigguy38@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(44,'bigguy39','bigguy39','bigguy39@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(45,'bigguy40','bigguy40','bigguy40@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(46,'bigguy41','bigguy41','bigguy41@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(47,'bigguy42','bigguy42','bigguy42@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(48,'bigguy43','bigguy43','bigguy43@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(49,'bigguy44','bigguy44','bigguy44@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(50,'bigguy45','bigguy45','bigguy45@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(51,'bigguy46','bigguy46','bigguy46@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(52,'bigguy47','bigguy47','bigguy47@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(53,'bigguy48','bigguy48','bigguy48@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(54,'bigguy49','bigguy49','bigguy49@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(55,'bigguy50','bigguy50','bigguy50@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(56,'bigguy51','bigguy51','bigguy51@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(57,'bigguy52','bigguy52','bigguy52@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(58,'bigguy53','bigguy53','bigguy53@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(59,'bigguy54','bigguy54','bigguy54@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(60,'bigguy55','bigguy55','bigguy55@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(61,'bigguy56','bigguy56','bigguy56@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(62,'bigguy57','bigguy57','bigguy57@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(63,'bigguy58','bigguy58','bigguy58@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(64,'bigguy59','bigguy59','bigguy59@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(65,'bigguy60','bigguy60','bigguy60@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(66,'bigguy61','bigguy61','bigguy61@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(67,'bigguy62','bigguy62','bigguy62@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(68,'bigguy63','bigguy63','bigguy63@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(69,'bigguy64','bigguy64','bigguy64@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(70,'bigguy65','bigguy65','bigguy65@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(71,'bigguy66','bigguy66','bigguy66@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(72,'bigguy67','bigguy67','bigguy67@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(73,'bigguy68','bigguy68','bigguy68@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(74,'bigguy69','bigguy69','bigguy69@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(75,'bigguy70','bigguy70','bigguy70@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(76,'bigguy71','bigguy71','bigguy71@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(77,'bigguy72','bigguy72','bigguy72@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(78,'bigguy73','bigguy73','bigguy73@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(79,'bigguy74','bigguy74','bigguy74@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(80,'bigguy75','bigguy75','bigguy75@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(81,'bigguy76','bigguy76','bigguy76@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(82,'bigguy77','bigguy77','bigguy77@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(83,'bigguy78','bigguy78','bigguy78@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(84,'bigguy79','bigguy79','bigguy79@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(85,'bigguy80','bigguy80','bigguy80@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(86,'bigguy81','bigguy81','bigguy81@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(87,'bigguy82','bigguy82','bigguy82@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(88,'bigguy83','bigguy83','bigguy83@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(89,'bigguy84','bigguy84','bigguy84@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(90,'bigguy85','bigguy85','bigguy85@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(91,'bigguy86','bigguy86','bigguy86@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(92,'bigguy87','bigguy87','bigguy87@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(93,'bigguy88','bigguy88','bigguy88@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(94,'bigguy89','bigguy89','bigguy89@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(95,'bigguy90','bigguy90','bigguy90@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(96,'bigguy91','bigguy91','bigguy91@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(97,'bigguy92','bigguy92','bigguy92@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(98,'bigguy93','bigguy93','bigguy93@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(99,'bigguy94','bigguy94','bigguy94@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(100,'bigguy95','bigguy95','bigguy95@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(101,'bigguy96','bigguy96','bigguy96@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(102,'bigguy97','bigguy97','bigguy97@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(103,'bigguy98','bigguy98','bigguy98@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1),(104,'bigguy99','bigguy99','bigguy99@163.com','http://t.cn/RCzsdCq','15570990166','1997-3-3',1);

/*Table structure for table `types` */

DROP TABLE IF EXISTS `types`;

CREATE TABLE `types` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `types` */

insert  into `types`(`id`,`name`) values (1,'电影'),(2,'电视剧'),(3,'综艺'),(4,'动漫'),(5,'纪录片'),(6,'短片');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` varchar(32) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`uid`,`username`,`password`,`email`) values ('23456','jeck','jeck123','15570990166@163.com'),('56785','tom','tom123',NULL);

/*Table structure for table `years` */

DROP TABLE IF EXISTS `years`;

CREATE TABLE `years` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `years` */

insert  into `years`(`id`,`name`) values (1,'2019'),(2,'2018'),(3,'2010年代'),(4,'2000年代'),(5,'90年代'),(6,'80年代'),(7,'70年代'),(8,'60年代'),(9,'更早');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
