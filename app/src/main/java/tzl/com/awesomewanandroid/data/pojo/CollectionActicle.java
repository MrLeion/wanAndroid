package tzl.com.awesomewanandroid.data.pojo;

import java.util.List;

/**
 * author: tangzenglei
 * created on: 2018/9/5 下午4:38
 * description:
 */
public class CollectionActicle {



        /**
         * curPage : 1
         * datas : [{"author":"小编","chapterId":352,"chapterName":"资讯","courseId":13,"desc":"","envelopePic":"","id":22292,"link":"http://www.wanandroid.com/blog/show/2","niceDate":"2018-08-21","origin":"","originId":2864,"publishTime":1534846549000,"title":"玩Android API","userId":5724,"visible":0,"zan":0},{"author":"小编","chapterId":281,"chapterName":"公司博客","courseId":13,"desc":"","envelopePic":"","id":18955,"link":"https://kaolamobile.github.io/","niceDate":"2018-07-31","origin":"","originId":2438,"publishTime":1533008844000,"title":"网易考拉移动端团队","userId":5724,"visible":0,"zan":0},{"author":"小编","chapterId":281,"chapterName":"公司博客","courseId":13,"desc":"","envelopePic":"","id":18954,"link":"https://tech.youzan.com/","niceDate":"2018-07-31","origin":"","originId":2681,"publishTime":1533008825000,"title":"有赞技术团队","userId":5724,"visible":0,"zan":0},{"author":"drakeet","chapterId":78,"chapterName":"性能优化","courseId":13,"desc":"","envelopePic":"","id":16434,"link":"http://drakeet.me/android-leaks/","niceDate":"2018-07-12","origin":"","originId":3131,"publishTime":1531373972000,"title":"Android 内存泄漏案例和解析","userId":5724,"visible":0,"zan":0},{"author":"小编","chapterId":281,"chapterName":"公司博客","courseId":13,"desc":"","envelopePic":"","id":15475,"link":"https://tech.meituan.com/","niceDate":"2018-07-02","origin":"","originId":1894,"publishTime":1530512536000,"title":"美团点评","userId":5724,"visible":0,"zan":0}]
         * offset : 0
         * over : true
         * pageCount : 1
         * size : 20
         * total : 5
         */

        private int curPage;
        private int             offset;
        private boolean         over;
        private int             pageCount;
        private int             size;
        private int             total;
        private List<CollectionJson> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<CollectionJson> getDatas() {
            return datas;
        }

        public void setDatas(List<CollectionJson> datas) {
            this.datas = datas;
        }

}
