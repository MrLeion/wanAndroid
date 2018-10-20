package tzl.com.awesomewanandroid.data.pojo;

import java.util.List;

/**
 * author: tangzenglei
 * created on: 2018/10/19 下午2:39
 * description:
 */
public class Topic {

    /**
     * id : 7H7NQX9e2N1
     * nelData : {"state":true,"result":[{"weight":0.751696765422821,"nerName":"上汽","entityId":"baike_3815551","entityName":"上汽集团","entityType":"company","entityUniqueId":"baike_3815551","finance":null},{"weight":1,"nerName":"大众","entityId":"baike_1147500","entityName":"大众汽车","entityType":"company","entityUniqueId":"baike_1147500","finance":null},{"weight":0.311861276626587,"nerName":"大众集团","entityId":"baike_587400","entityName":"大众集团","entityType":"company","entityUniqueId":"baike_587400","finance":null},{"weight":0.677288234233856,"nerName":"奥迪","entityId":"baike_24117","entityName":"奥迪","entityType":"company","entityUniqueId":"baike_24117","finance":null},{"weight":0.353380769491196,"nerName":"斯柯达","entityId":"baike_1435924","entityName":"斯柯达","entityType":"company","entityUniqueId":"baike_1435924","finance":null},{"weight":0.309966295957565,"nerName":"陈虹","entityId":"baike_2834721","entityName":"陈虹","entityType":"person","entityUniqueId":"baike_2834721","finance":null}]}
     * newsArray : [{"id":1049786,"url":"http://auto.qq.com/a/20181019/007617.htm","title":"上汽大众新能源汽车工厂开工 将生产奥迪等品牌车型","siteName":"腾讯科技","mobileUrl":"http://auto.qq.com/a/20181019/007617.htm","autherName":"","duplicateId":1,"publishDate":"2018-10-19T03:32:00.000Z"}]
     * createdAt : 2018-10-19T06:09:13.042Z
     * eventData : []
     * publishDate : 2018-10-19T06:09:13.028Z
     * summary : 上汽也将以新工厂建设为起点，将上汽大众安亭基地进一步打造成集“智能制造、研发创新”为一体的现代化汽车园区，助力打响“上海制造”品牌 ... 上汽集团董事长陈虹表示，两年后，一座数字化、智能化、集成化的绿色环保工厂将在这里拔地而起，将生产基于德国大众最新电动车平台，包括奥迪、大众等品牌的多款新能源产品 ... 上汽大众新能源汽车工厂位于上海安亭，项目总投入170亿元，计划于2020年建成投产，规划年产能30万辆。
     * title : 上汽大众新能源汽车工厂开工，将生产奥迪等品牌车型
     * updatedAt : 2018-10-19T06:11:57.928Z
     * timeline : 7GihfwmsIlG
     * order : 75968
     * extra : {"instantView":false}
     */

    public String              id;
    public NelDataBean         nelData;
    public String              createdAt;
    public String              publishDate;
    public String              summary;
    public String              title;
    public String              updatedAt;
    public String              timeline;
    public int                 order;
    public ExtraBean           extra;
    public List<NewsArrayBean> newsArray;
    public List<?>             eventData;


    public static class NelDataBean {
        /**
         * state : true
         * result : [{"weight":0.751696765422821,"nerName":"上汽","entityId":"baike_3815551","entityName":"上汽集团","entityType":"company","entityUniqueId":"baike_3815551","finance":null},{"weight":1,"nerName":"大众","entityId":"baike_1147500","entityName":"大众汽车","entityType":"company","entityUniqueId":"baike_1147500","finance":null},{"weight":0.311861276626587,"nerName":"大众集团","entityId":"baike_587400","entityName":"大众集团","entityType":"company","entityUniqueId":"baike_587400","finance":null},{"weight":0.677288234233856,"nerName":"奥迪","entityId":"baike_24117","entityName":"奥迪","entityType":"company","entityUniqueId":"baike_24117","finance":null},{"weight":0.353380769491196,"nerName":"斯柯达","entityId":"baike_1435924","entityName":"斯柯达","entityType":"company","entityUniqueId":"baike_1435924","finance":null},{"weight":0.309966295957565,"nerName":"陈虹","entityId":"baike_2834721","entityName":"陈虹","entityType":"person","entityUniqueId":"baike_2834721","finance":null}]
         */
        public boolean state;
        public List<ResultBean> result;


        @Override
        public String toString() {
            return "NelDataBean{" +
                    "state=" + state +
                    ", result=" + result +
                    '}';
        }

        public static class ResultBean {
            /**
             * weight : 0.751696765422821
             * nerName : 上汽
             * entityId : baike_3815551
             * entityName : 上汽集团
             * entityType : company
             * entityUniqueId : baike_3815551
             * finance : null
             */

            public double weight;
            public String nerName;
            public String entityId;
            public String entityName;
            public String entityType;
            public String entityUniqueId;
            public Object finance;


            @Override
            public String toString() {
                return "ResultBean{" +
                        "weight=" + weight +
                        ", nerName='" + nerName + '\'' +
                        ", entityId='" + entityId + '\'' +
                        ", entityName='" + entityName + '\'' +
                        ", entityType='" + entityType + '\'' +
                        ", entityUniqueId='" + entityUniqueId + '\'' +
                        ", finance=" + finance +
                        '}';
            }
        }
    }

    public static class ExtraBean {
        /**
         * instantView : false
         */

        public boolean instantView;

        @Override
        public String toString() {
            return "ExtraBean{" +
                    "instantView=" + instantView +
                    '}';
        }
    }

    public static class NewsArrayBean {
        /**
         * id : 1049786
         * url : http://auto.qq.com/a/20181019/007617.htm
         * title : 上汽大众新能源汽车工厂开工 将生产奥迪等品牌车型
         * siteName : 腾讯科技
         * mobileUrl : http://auto.qq.com/a/20181019/007617.htm
         * autherName :
         * duplicateId : 1
         * publishDate : 2018-10-19T03:32:00.000Z
         */

        public int id;
        public String url;
        public String title;
        public String siteName;
        public String mobileUrl;
        public String autherName;
        public int    duplicateId;
        public String publishDate;

        @Override
        public String toString() {
            return "NewsArrayBean{" +
                    "id=" + id +
                    ", url='" + url + '\'' +
                    ", title='" + title + '\'' +
                    ", siteName='" + siteName + '\'' +
                    ", mobileUrl='" + mobileUrl + '\'' +
                    ", autherName='" + autherName + '\'' +
                    ", duplicateId=" + duplicateId +
                    ", publishDate='" + publishDate + '\'' +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "Topic{" +
                "id='" + id + '\'' +
                ", nelData=" + nelData +
                ", createdAt='" + createdAt + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", summary='" + summary + '\'' +
                ", title='" + title + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", timeline='" + timeline + '\'' +
                ", order=" + order +
                ", extra=" + extra +
                ", newsArray=" + newsArray +
                ", eventData=" + eventData +
                '}';
    }
}
