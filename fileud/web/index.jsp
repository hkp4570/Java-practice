<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>保存文件</title>
  </head>
  <body>
  <form action="saveFile" method="post" enctype="multipart/form-data">
    请输入名字：<input type="text" name="username" value=""><br />
    请选择文件1：<input type="file" name="testFile1" value=""><br />
    请选择文件2：<input type="file" name="testFile2" value=""><br />
    请选择文件3：<input type="file" name="testFile3" value=""><br />
    <input type="submit" value="确定">
  </form>
  </body>
</html>
