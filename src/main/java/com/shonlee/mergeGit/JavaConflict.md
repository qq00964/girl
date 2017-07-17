    为了构造一个冲突的环境用于书写这篇博客，本人采用这种方式：先在IDEA中新建README.md文件，把一个文件上传（push）到github上面，然后在github这个网站上手动修改这个文件中的内容，这样，当在本地pull下README.md文件的时候就会提示代码冲突了。

1、本地文件修改如下图：
    ![](http://img.blog.csdn.net/20160822160436245?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

2、远程服务git中的文件如下图：
    ![](http://img.blog.csdn.net/20160822160440757?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

3、先commit本地修改的文件到本地repository
    ![](http://img.blog.csdn.net/20160822160444339?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

4、pull源码，因为存在代码冲突，所以接下来会自动弹出merge融合窗口，如下图：
    ![](http://img.blog.csdn.net/20160822160449448?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)
    ![](http://img.blog.csdn.net/20160822160452901?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

5、点击merge，进入下图：下图中，左边是本地修改后的，右边是远程git上面的，中间是本地修改之前的。我们可以在修改中间栏的。
    ![](http://img.blog.csdn.net/20160822160458023?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

编辑之后，如下图，最后点击apply，这样冲突就解决了，但是我们还需要提交本地代码到本地和远程仓库中。
    ![](http://img.blog.csdn.net/20160822160501151?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

6、git -- commit files--，提交代码到本地或者远程仓库
    ![](http://img.blog.csdn.net/20160822160506710?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

查看结果：说明我们解决了冲突。
    ![](http://img.blog.csdn.net/20160822161632413?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)