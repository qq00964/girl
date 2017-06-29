<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <meta charset="UTF-8">
    <title>JavaScript</title>
</head>
<body>
<h1>Test</h1>
<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    $(function() {
        var arr=['A', 'B', 'C', 'D', 'E', 'F', 'G'];
        var a=arr.slice(1,3);
        confirm(a);
    })
</script>
</body>
</html>