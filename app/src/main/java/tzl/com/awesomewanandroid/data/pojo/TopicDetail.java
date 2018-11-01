package tzl.com.awesomewanandroid.data.pojo;

import java.util.List;

/**
 * author: tangzenglei
 * created on: 2018/10/31 下午4:49
 * description:
 */
public class TopicDetail {


    /**
     * id : 7HqeLh13WOv
     * entityTopics : [{"weight":0.703118979930878,"nerName":"京东方","entityId":"baike_9019273","entityName":"京东方","entityType":"company","entityUniqueId":"baike_9019273","finance":{"code":"SZ:000725","name":"京东方A"}}]
     * newsArray : [{"id":"7Hr49u4cahf","url":"https://finance.qq.com/a/20181030/014159.htm","title":"京东方2018年第三季度实现营收259.9亿元","siteName":"腾讯科技","mobileUrl":"https://finance.qq.com/a/20181030/014159.htm","autherName":"","duplicateId":1,"publishDate":"2018-10-30T03:41:00.000Z"}]
     * createdAt : 2018-10-31T09:42:32.105Z
     * entityEventTopics : []
     * publishDate : 2018-10-31T09:42:32.100Z
     * summary : 全球市场调研机构IHS数据显示，第三季度全球大尺寸液晶显示面板出货量较去年同期增长7%，出货面积较去年同期增长14%，BOE（京东方）以23%的大尺寸面板市占率稳居全球第一 ... BOE（京东方）柔性AMOLED显示屏已为多家全球知名品牌供货，根据行业研究机构CINNO Research最新报告，BOE（京东方）AMOLED手机面板出货量持续增长，出货面积环比增长62%，成为第三季度国内AMOLED手机面板出货大幅增长的主要原因，第四季度出货量有望继续保持50%左右的环比增长 ... BOE（京东方）副总裁、董秘刘洪峰表示：截至第三季度，京东方智能手机液晶显示屏、平板电脑显示屏、笔记本电脑显示屏、显示器显示屏、电视显示屏出货量继续蝉联全球第一。
     * title : 京东方2018年第三季度实现营收259.9亿元
     * updatedAt : 2018-10-31T09:43:21.492Z
     * timeline : {"topics":[{"id":"7HqeLh13WOv","title":"京东方2018年第三季度实现营收259.9亿元","createdAt":"2018-10-31T09:42:32.105Z"},{"id":"7H2ZaKFMpMt","title":"外媒：三星显示将投88亿美元砸QD-OLED","createdAt":"2018-10-17T04:44:36.240Z"},{"id":"7GLtBiOWRwO","title":"外媒：京东方寻求为三星智能手表供应OLED面板","createdAt":"2018-10-06T02:31:19.373Z"},{"id":"1ZuT7LA7r1B","title":"京东方寻求为苹果iPhone供应OLED屏：与三星等竞争","createdAt":"2018-07-22T23:33:50.766Z"},{"id":"5ovZTbIza3o","title":"曝华为Mate 20 Pro将搭载京东方曲面屏 支持屏幕指纹","createdAt":"2018-07-16T04:41:52.448Z"}],"commonEntities":[{"id":328843,"topicId":"7HqeLh13WOv","nerName":"京东方","weight":0.703118979930878,"entityId":"baike_9019273","entityType":"company","entityName":"京东方","isMain":true,"extra":{"finance":{"code":"000725","name":"京东方A","state":1,"exchange":"SZ","bussiness":"电子"}},"createdAt":"2018-10-31T09:42:32.136Z","updatedAt":"2018-10-31T09:42:32.220Z"}],"id":"7GM9gCvghXO"}
     * order : 79874
     * hasInstantView : false
     */

    private String id;
    private String                 createdAt;
    private String                 publishDate;
    private String                 summary;
    private String                 title;
    private String                 updatedAt;
    private TimelineBean           timeline;
    private int                    order;
    private boolean                hasInstantView;
    private List<EntityTopicsBean> entityTopics;
    private List<NewsArrayBean>    newsArray;
    private List<?>                entityEventTopics;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public TimelineBean getTimeline() {
        return timeline;
    }

    public void setTimeline(TimelineBean timeline) {
        this.timeline = timeline;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isHasInstantView() {
        return hasInstantView;
    }

    public void setHasInstantView(boolean hasInstantView) {
        this.hasInstantView = hasInstantView;
    }

    public List<EntityTopicsBean> getEntityTopics() {
        return entityTopics;
    }

    public void setEntityTopics(List<EntityTopicsBean> entityTopics) {
        this.entityTopics = entityTopics;
    }

    public List<NewsArrayBean> getNewsArray() {
        return newsArray;
    }

    public void setNewsArray(List<NewsArrayBean> newsArray) {
        this.newsArray = newsArray;
    }

    public List<?> getEntityEventTopics() {
        return entityEventTopics;
    }

    public void setEntityEventTopics(List<?> entityEventTopics) {
        this.entityEventTopics = entityEventTopics;
    }

    public static class TimelineBean {
        /**
         * topics : [{"id":"7HqeLh13WOv","title":"京东方2018年第三季度实现营收259.9亿元","createdAt":"2018-10-31T09:42:32.105Z"},{"id":"7H2ZaKFMpMt","title":"外媒：三星显示将投88亿美元砸QD-OLED","createdAt":"2018-10-17T04:44:36.240Z"},{"id":"7GLtBiOWRwO","title":"外媒：京东方寻求为三星智能手表供应OLED面板","createdAt":"2018-10-06T02:31:19.373Z"},{"id":"1ZuT7LA7r1B","title":"京东方寻求为苹果iPhone供应OLED屏：与三星等竞争","createdAt":"2018-07-22T23:33:50.766Z"},{"id":"5ovZTbIza3o","title":"曝华为Mate 20 Pro将搭载京东方曲面屏 支持屏幕指纹","createdAt":"2018-07-16T04:41:52.448Z"}]
         * commonEntities : [{"id":328843,"topicId":"7HqeLh13WOv","nerName":"京东方","weight":0.703118979930878,"entityId":"baike_9019273","entityType":"company","entityName":"京东方","isMain":true,"extra":{"finance":{"code":"000725","name":"京东方A","state":1,"exchange":"SZ","bussiness":"电子"}},"createdAt":"2018-10-31T09:42:32.136Z","updatedAt":"2018-10-31T09:42:32.220Z"}]
         * id : 7GM9gCvghXO
         */

        private String id;
        private List<TopicsBean>         topics;
        private List<CommonEntitiesBean> commonEntities;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<TopicsBean> getTopics() {
            return topics;
        }

        public void setTopics(List<TopicsBean> topics) {
            this.topics = topics;
        }

        public List<CommonEntitiesBean> getCommonEntities() {
            return commonEntities;
        }

        public void setCommonEntities(List<CommonEntitiesBean> commonEntities) {
            this.commonEntities = commonEntities;
        }

        public static class TopicsBean {
            /**
             * id : 7HqeLh13WOv
             * title : 京东方2018年第三季度实现营收259.9亿元
             * createdAt : 2018-10-31T09:42:32.105Z
             */

            private String id;
            private String title;
            private String createdAt;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }
        }

        public static class CommonEntitiesBean {
            /**
             * id : 328843
             * topicId : 7HqeLh13WOv
             * nerName : 京东方
             * weight : 0.703118979930878
             * entityId : baike_9019273
             * entityType : company
             * entityName : 京东方
             * isMain : true
             * extra : {"finance":{"code":"000725","name":"京东方A","state":1,"exchange":"SZ","bussiness":"电子"}}
             * createdAt : 2018-10-31T09:42:32.136Z
             * updatedAt : 2018-10-31T09:42:32.220Z
             */

            private int id;
            private String    topicId;
            private String    nerName;
            private double    weight;
            private String    entityId;
            private String    entityType;
            private String    entityName;
            private boolean   isMain;
            private ExtraBean extra;
            private String    createdAt;
            private String    updatedAt;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTopicId() {
                return topicId;
            }

            public void setTopicId(String topicId) {
                this.topicId = topicId;
            }

            public String getNerName() {
                return nerName;
            }

            public void setNerName(String nerName) {
                this.nerName = nerName;
            }

            public double getWeight() {
                return weight;
            }

            public void setWeight(double weight) {
                this.weight = weight;
            }

            public String getEntityId() {
                return entityId;
            }

            public void setEntityId(String entityId) {
                this.entityId = entityId;
            }

            public String getEntityType() {
                return entityType;
            }

            public void setEntityType(String entityType) {
                this.entityType = entityType;
            }

            public String getEntityName() {
                return entityName;
            }

            public void setEntityName(String entityName) {
                this.entityName = entityName;
            }

            public boolean isIsMain() {
                return isMain;
            }

            public void setIsMain(boolean isMain) {
                this.isMain = isMain;
            }

            public ExtraBean getExtra() {
                return extra;
            }

            public void setExtra(ExtraBean extra) {
                this.extra = extra;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }

            public static class ExtraBean {
                /**
                 * finance : {"code":"000725","name":"京东方A","state":1,"exchange":"SZ","bussiness":"电子"}
                 */

                private FinanceBean finance;

                public FinanceBean getFinance() {
                    return finance;
                }

                public void setFinance(FinanceBean finance) {
                    this.finance = finance;
                }

                public static class FinanceBean {
                    /**
                     * code : 000725
                     * name : 京东方A
                     * state : 1
                     * exchange : SZ
                     * bussiness : 电子
                     */

                    private String code;
                    private String name;
                    private int    state;
                    private String exchange;
                    private String bussiness;

                    public String getCode() {
                        return code;
                    }

                    public void setCode(String code) {
                        this.code = code;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getState() {
                        return state;
                    }

                    public void setState(int state) {
                        this.state = state;
                    }

                    public String getExchange() {
                        return exchange;
                    }

                    public void setExchange(String exchange) {
                        this.exchange = exchange;
                    }

                    public String getBussiness() {
                        return bussiness;
                    }

                    public void setBussiness(String bussiness) {
                        this.bussiness = bussiness;
                    }
                }
            }
        }
    }

    public static class EntityTopicsBean {
        /**
         * weight : 0.703118979930878
         * nerName : 京东方
         * entityId : baike_9019273
         * entityName : 京东方
         * entityType : company
         * entityUniqueId : baike_9019273
         * finance : {"code":"SZ:000725","name":"京东方A"}
         */

        private double weight;
        private String       nerName;
        private String       entityId;
        private String       entityName;
        private String       entityType;
        private String       entityUniqueId;
        private FinanceBeanX finance;

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public String getNerName() {
            return nerName;
        }

        public void setNerName(String nerName) {
            this.nerName = nerName;
        }

        public String getEntityId() {
            return entityId;
        }

        public void setEntityId(String entityId) {
            this.entityId = entityId;
        }

        public String getEntityName() {
            return entityName;
        }

        public void setEntityName(String entityName) {
            this.entityName = entityName;
        }

        public String getEntityType() {
            return entityType;
        }

        public void setEntityType(String entityType) {
            this.entityType = entityType;
        }

        public String getEntityUniqueId() {
            return entityUniqueId;
        }

        public void setEntityUniqueId(String entityUniqueId) {
            this.entityUniqueId = entityUniqueId;
        }

        public FinanceBeanX getFinance() {
            return finance;
        }

        public void setFinance(FinanceBeanX finance) {
            this.finance = finance;
        }

        public static class FinanceBeanX {
            /**
             * code : SZ:000725
             * name : 京东方A
             */

            private String code;
            private String name;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class NewsArrayBean {
        /**
         * id : 7Hr49u4cahf
         * url : https://finance.qq.com/a/20181030/014159.htm
         * title : 京东方2018年第三季度实现营收259.9亿元
         * siteName : 腾讯科技
         * mobileUrl : https://finance.qq.com/a/20181030/014159.htm
         * autherName :
         * duplicateId : 1
         * publishDate : 2018-10-30T03:41:00.000Z
         */

        private String id;
        private String url;
        private String title;
        private String siteName;
        private String mobileUrl;
        private String autherName;
        private int    duplicateId;
        private String publishDate;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSiteName() {
            return siteName;
        }

        public void setSiteName(String siteName) {
            this.siteName = siteName;
        }

        public String getMobileUrl() {
            return mobileUrl;
        }

        public void setMobileUrl(String mobileUrl) {
            this.mobileUrl = mobileUrl;
        }

        public String getAutherName() {
            return autherName;
        }

        public void setAutherName(String autherName) {
            this.autherName = autherName;
        }

        public int getDuplicateId() {
            return duplicateId;
        }

        public void setDuplicateId(int duplicateId) {
            this.duplicateId = duplicateId;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }
    }
}
