<template>
    <div>
        <b-card no-body>
            <b-tabs card>
                <b-tab title="공지사항" active @click="moveTab('NOTICE')">
                    <article-info></article-info>
                </b-tab>

                <b-tab title="Q & A" @click="moveTab('QNA')">
                    <article-info></article-info>
                </b-tab>
            </b-tabs>
        </b-card>
    </div>
</template>

<script>
import ArticleInfo from "@/page/ArticleInfo.vue";

export default {
    name: "article",
    data() {
        return {
            params: {
                key: "",
                word: "",
                page: 1,
                articleType: "NOTICE",
            },
        };
    },
    components: {
        ArticleInfo,
    },
    methods: {
        moveTab(tab) {
            this.params.articleType = tab;
            this.$store.dispatch("getArticles", this.params);
        },
    },
    mounted() {
        this.$store.dispatch("getArticles", this.params);
    },
};
</script>

<style></style>
