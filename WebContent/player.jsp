<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script language="javascript">
var BdPlayer = new Array();
BdPlayer['time'] = 8;//缓冲广告展示时间(如果设为0,则根据缓冲进度自动控制广告展示时间)
BdPlayer['buffer'] = 'http://player.baidu.com/lib/show.html?buffer';//贴片广告网页地址
BdPlayer['pause'] = 'http://player.baidu.com/lib/show.html?pause';//暂停广告网页地址
BdPlayer['end'] = 'http://player.baidu.com/lib/show.html?end';//影片播放完成后加载的广告
BdPlayer['tn'] = '12345678';//播放器下载地址渠道号
BdPlayer['width'] = 800;//播放器宽度(只能为数字)
BdPlayer['height'] = 550;//播放器高度(只能为数字)
BdPlayer['showclient'] = 1;//是否显示拉起拖盘按钮(1为显示 0为隐藏)
BdPlayer['url'] = 'ftp://dy131.com:6vdy.com@ftp1.66e.cc:2125/【最新电影www.66e.cc】墨水心BD国语中字1024高清.rmvb';//当前播放任务播放地址
BdPlayer['nextcacheurl'] = 'bdhd://258153089|948E0EB38A2DFA1AF7D1B488E86AFFDD|还珠格格之燕儿翩翩飞02.HDTV.rmvb';//下一集播放地址(没有请留空)
BdPlayer['lastwebpage'] = 'http://player.baidu.com/lib/eg.html?1';//上一集网页地址(没有请留空)
BdPlayer['nextwebpage'] = 'http://player.baidu.com/lib/eg.html?2';//下一集网页地址(没有请留空)
</script>
<script language="javascript" src="http://php.player.baidu.com/bdplayer/player.js" charset="utf-8"></script>
</body>
</html>