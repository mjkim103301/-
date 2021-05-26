<template>
    <div>
        <div class="text-right">
            <router-link class="btn btn-primary" :to="`/happyhouse/article`"
                >목록</router-link
            >
            <router-link
                v-if="session.userId == article.userId || session.admin == 1"
                class="btn btn-primary"
                :to="`/happyhouse/article/update/${article.articleId}`"
                >수정</router-link
            >
            <router-link
                v-if="session.userId == article.userId || session.admin == 1"
                class="btn btn-primary"
                :to="`/happyhouse/article/remove/${article.articleId}`"
                >삭제</router-link
            >
        </div>
        <table class="table table-condensed w-25" v-if="article">
            <tr>
                <th>글번호</th>
                <td v-text="article.articleId"></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>
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
                </td>

                <td></td>
            </tr>
            <tr>
                <th>제목</th>
                <td v-text="article.subject"></td>
            </tr>
            <tr>
                <th>날짜</th>
                <td>{{ article.registerTime | toDate }}</td>
            </tr>

            <tr>
                <th>내용</th>
                <td colspan="2" v-text="article.content"></td>
            </tr>
            <tr>
                <th>조회수</th>
                <td>{{ article.hit }}</td>
            </tr>
        </table>

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
            return moment(new Date(regtime)).format("YYYY.MM.DD");
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
