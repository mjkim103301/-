import Vue from "vue";
import VueRouter from "vue-router";
import Article from "@/components/article/Article.vue";
//import List from "@/components/List.vue";
import WriteArticle from "@/components/article/WriteArticle.vue";
import DetailArticle from "@/components/article/DetailArticle.vue";
import UpdateArticle from "@/components/article/UpdateArticle.vue";
import ListReply from "@/components/reply/ListReply.vue";
import RemoveArticle from "@/components/article/RemoveArticle.vue";
import ListUser from "@/components/admin/ListUser.vue";

Vue.use(VueRouter);

const routes = [
    {
        path: "/happyhouse/article",
        name: "Article",
        component: Article,
    },
    {
        path: "/happyhouse/article/write",
        name: "WriteArticle",
        component: WriteArticle,
    },

    {
        path: "/happyhouse/article/:articleId",
        name: "DetailArticle",
        component: DetailArticle,
        children: [
            {
                path: "",
                name: "ListReply",
                component: ListReply,
            },
        ],
    },

    {
        path: "/happyhouse/article/update/:articleId",
        name: "UpdateArticle",
        component: UpdateArticle,
    },

    {
        path: "/happyhouse/article/remove/:articleId",
        name: "RemoveArticle",
        component: RemoveArticle,
    },
    {
        path: "/happyhouse/admin",
        name: "ListUser",
        component: ListUser,
    },
];

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes,
});

export default router;
