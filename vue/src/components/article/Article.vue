<template>
    <div>
        <b-card no-body>
            <b-tabs card>
                <b-tab title="전체 게시판" active @click="moveTab('')">
                    <list-article></list-article>
                </b-tab>

                <b-tab title="공지사항" @click="moveTab('NOTICE')">
                    <list-article></list-article>
                </b-tab>

                <b-tab title="Q & A" @click="moveTab('QNA')">
                    <list-article></list-article>
                </b-tab>

                <b-tab title="자유 게시판" @click="moveTab('FREE')">
                    <list-article></list-article>
                </b-tab>
            </b-tabs>
        </b-card>
    </div>
</template>

<script>
import ListArticle from "@/components/article/ListArticle.vue";
import { mapGetters } from "vuex";

export default {
    name: "article",
    computed: {
        ...mapGetters(["pageParams", "session"]),
    },
    components: {
        ListArticle,
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
        this.$store.dispatch("getSession");
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
