<template>
    <div>
        <div class="text-right">
            <router-link class="btn btn-info" :to="`/happyhouse/article`"
                >목록</router-link
            >
            <router-link
                v-if="session.userId == article.userId || session.admin == 1"
                class="btn btn-info ml-2"
                :to="`/happyhouse/article/update/${article.articleId}`"
                >수정</router-link
            >
            <router-link
                v-if="session.userId == article.userId || session.admin == 1"
                class="btn btn-info ml-2"
                :to="`/happyhouse/article/remove/${article.articleId}`"
                >삭제</router-link
            >
        </div>
        <div class="" v-if="article">
            <div v-if="article.articleType == 'QNA'">QnA 게시판</div>
            <div v-if="article.articleType == 'NOTICE'">공지사항</div>
            <div v-if="article.articleType == 'FREE'">자유 게시판</div>
            <h2 v-text="article.subject" class="mt-2"></h2>
            <div class="row">
                <div class="col-sm-6">
                    <span
                        v-if="article.userCampus == 'ADMIN'"
                        class="badge badge-danger"
                        >프로</span
                    >
                    <span
                        v-if="article.userCampus == '서울'"
                        class="badge badge-warning"
                        >서울</span
                    >
                    <span
                        v-if="article.userCampus == '대전'"
                        class="badge badge-success"
                        >대전</span
                    >
                    <span
                        v-if="article.userCampus == '광주'"
                        class="badge badge-info"
                        >광주</span
                    >
                    <span
                        v-if="article.userCampus == '구미'"
                        class="badge badge-primary"
                        >구미</span
                    >
                    <span
                        v-if="
                            !article.userCampus ||
                            article.userCampus.length == 0
                        "
                        class="badge badge-secondary"
                        >손님</span
                    >
                    {{ article.userId }}
                    <span class="ml-3">
                        {{ article.registerTime | toDate }}</span
                    >
                </div>
                <div class="col-sm-6 text-right" style="text-align: center">
                    👀 {{ article.hit }}
                </div>
            </div>
            <hr />
            <div v-text="article.content" class="mb-4"></div>
        </div>

        <router-view></router-view>
    </div>
</template>
<script>
import moment from "moment";
import { mapGetters } from "vuex";

export default {
    computed: {
        ...mapGetters(["article", "session"]),
    },
    filters: {
        toDate: function (regtime) {
            return moment(new Date(regtime)).format("YYYY.MM.DD HH:MM");
        },
    },
    created() {
        console.log(`[search] created`);
        this.$store.dispatch(
            "getArticle",
            `/article/${this.$route.params.articleId}`
        );
        console.log(`search.vue article 경로 ${this.$route.params.articleId}`);
    },
    mounted() {
        this.$store.dispatch("getSession");
    },
};
</script>
