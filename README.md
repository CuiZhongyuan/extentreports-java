## 修改extentreports静态文件路径
文件路径：extentreports-java\src\main\resources\com\aventstack\extentreports\view\html-report\
下的head.ftl和index.ftl文件
修改内容为：(改为访问项目中的静态文件)
第一处：head.ftl
15行：<link href='./css/extent.css' type='text/css' rel='stylesheet' />
第二处：index.ftl
97行：<script src='./js/extent.js' type='text/javascript'></script>
