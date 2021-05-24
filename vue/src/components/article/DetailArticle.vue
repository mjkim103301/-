<template>
    <div>
        <table class="table table-condensed w-25" v-if="article">
            <tr>
                <th>글번호</th>
                <td v-text="article.articleId"></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td v-text="article.userId"></td>
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

        <table v-else>
            <tr>
                <th>글번호</th>
                <td v-text="1"></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td v-text="김싸피"></td>
            </tr>
            <tr>
                <th>제목</th>
                <td>default</td>
            </tr>
            <tr>
                <th>날짜</th>
                <td>2020-05-18</td>
            </tr>

            <tr>
                <th>내용</th>
                <td colspan="2">default</td>
            </tr>
            <tr>
                <th>조회수</th>
                <td>1</td>
            </tr>
        </table>

        <div class="text-right">
            <router-link class="btn btn-primary" :to="`/happyhouse/article`"
                >목록</router-link
            >
            <router-link
                class="btn btn-primary"
                :to="`/happyhouse/article/update/${article.articleId}`"
                >수정</router-link
            >
            <router-link
                class="btn btn-primary"
                :to="`/happyhouse/article/remove/${article.articleId}`"
                >삭제</router-link
            >
        </div>
        <router-view></router-view>
    </div>
</template>
<script>
import moment from "moment";
import { mapGetters } from "vuex";

export default {
    computed: {
        ...mapGetters(["article"]),
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
};
</script>
