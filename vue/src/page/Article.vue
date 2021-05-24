<template>
    <div>
        <b-card no-body>
            <b-tabs card>
                <b-tab title="전체 게시판" active @click="moveTab('')">
                    <article-list></article-list>
                </b-tab>

                <b-tab title="공지사항" @click="moveTab('NOTICE')">
                    <article-list></article-list>
                </b-tab>

                <b-tab title="Q & A" @click="moveTab('QNA')">
                    <article-list></article-list>
                </b-tab>

                <b-tab title="자유 게시판" @click="moveTab('FREE')">
                    <article-list></article-list>
                </b-tab>
            </b-tabs>
        </b-card>
    </div>
</template>

<script>
import ArticleList from "@/page/ArticleList.vue";
import { mapGetters } from "vuex";

export default {
    name: "article",
    computed: {
        ...mapGetters["pageParams"],
    },
    components: {
        ArticleList,
    },
    methods: {
        moveTab(tab) {
            this.$store.dispatch("getPageParams", {
                page: 1,
                key: "",
                word: "",
                articleType: tab,
            });

            this.$store.dispatch("getArticles");
        },
    },
    mounted() {
        this.$store.dispatch("getPageParams", {
            page: 1,
            key: "",
            word: "",
            articleType: "",
        });
        this.$store.dispatch("getArticles");
    },
};
</script>

<style></style>
