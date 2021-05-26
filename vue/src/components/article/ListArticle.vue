<template>
    <div>
        <section id="" class="p-1">
            <div class="container">
                <div class="mb-2">
                    <button
                        v-if="session.userId != null && session.userId != ''"
                        type="button"
                        id="write-notice"
                        class="btn btn-primary"
                        @click="moveWritePage"
                    >
                        글쓰기
                    </button>
                    <form class="form-inline float-right">
                        <div class="form-group mr-sm-2">
                            <select
                                class="form-control selectOption"
                                id="selectOption"
                            >
                                <option selected value="subject">제목</option>
                                <option value="content">내용</option>
                                <option value="user_id">작성자</option>
                                <option value="article_id">글 번호</option>
                            </select>
                        </div>
                        <div class="form-group mr-sm-2">
                            <input
                                type="text"
                                class="form-control searchWord"
                                id="searchWord"
                                @keypress.enter="searchArticleHandler()"
                            />
                        </div>
                        <button
                            type="button"
                            class="btn btn-secondary"
                            @click="searchArticleHandler()"
                        >
                            검색
                        </button>
                    </form>
                </div>
                <div class="p-2 mb-5">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>글번호</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>조회수</th>
                                <th>작성일</th>
                            </tr>
                        </thead>
                        <tbody v-if="articles.length > 0">
                            <tr
                                v-for="(article, index) in articles"
                                :key="index"
                            >
                                <td>{{ article.articleId }}</td>
                                <td class="selectPost">
                                    <router-link
                                        :to="`/happyhouse/article/${article.articleId}`"
                                        style="color: black"
                                        >{{ article.subject }}</router-link
                                    >
                                </td>
                                <!-- <td
                                    v-html=""
                                > -->
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
                                <td>{{ article.hit }}</td>
                                <td>{{ article.registerTime }}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="mt-3">
                    <ul class="pagination justify-content-center">
                        <li class="page-item">
                            <a class="page-link" @click="movePageHandler(1)"
                                >최신</a
                            >
                        </li>
                        <li class="page-item">
                            <a
                                class="page-link"
                                @click="movePageHandler(page - 5)"
                                >이전</a
                            >
                        </li>
                        <li
                            v-for="nav in navigationItem"
                            :key="nav"
                            class="page-item"
                        >
                            <a
                                v-if="nav == page"
                                class="page-link bg-primary text-light"
                                @click="movePageHandler(nav)"
                                >{{ nav }}</a
                            >
                            <a
                                v-else
                                class="page-link"
                                @click="movePageHandler(nav)"
                                >{{ nav }}</a
                            >
                        </li>

                        <li class="page-item">
                            <a
                                class="page-link"
                                @click="movePageHandler(page + 5)"
                                >다음</a
                            >
                        </li>
                        <li class="page-item">
                            <a
                                class="page-link"
                                @click="movePageHandler(lastPage)"
                                >마지막</a
                            >
                        </li>
                    </ul>
                </div>
            </div>
        </section>
    </div>
</template>
<script>
import moment from "moment";
import { mapGetters } from "vuex";

import http from "@/util/http-common.js";

export default {
    name: "articleInfo",
    computed: {
        ...mapGetters(["articles", "pageParams", "session"]),
        changedParams: function () {
            return {
                page: this.$store.getters.pageParams.page,
                key: this.$store.getters.pageParams.key,
                word: this.$store.getters.pageParams.word,
                articleType: this.$store.getters.pageParams.articleType,
            };
        },
    },
    watch: {
        changedParams(val) {
            console.log("watch init");
            this.page = val.page;
            this.createNavigation();
            console.log("watch end");
        },
    },

    data() {
        return {
            page: 1,
            lastPage: 1,
            navigationItem: [],
        };
    },
    filters: {
        toDate: function (regtime) {
            return moment(new Date(regtime)).format("YY.M.D H시 mm분");
        },
    },
    methods: {
        searchArticleHandler() {
            // document.getElementsByClassName;
            let params = this.$store.getters.pageParams;
            let idx = 0;
            switch (this.$store.getters.pageParams.articleType) {
                case "NOTICE":
                    idx = 1;
                    break;
                case "QNA":
                    idx = 2;
                    break;
                case "FREE":
                    idx = 3;
                    break;
            }
            params.key =
                document.getElementsByClassName("selectOption")[idx].value;
            params.word =
                document.getElementsByClassName("searchWord")[idx].value;
            params.page = 1;
            console.log("search userHandler : " + this.key + this.word);
            this.$store.dispatch("getPageParams", params);
            this.$store.dispatch("getArticles");
        },

        moveWritePage() {
            this.$router.push("/happyhouse/article/write");
        },
        movePageHandler(page) {
            console.log("move page handler");
            this.page =
                page > this.lastPage ? this.lastPage : page < 1 ? 1 : page;
            console.log(
                "pages " + this.page + " " + page + " " + this.lastPage
            );

            let pageParams = this.$store.getters.pageParams;
            console.log(pageParams);
            pageParams.page = this.page;
            this.$store.dispatch("getPageParams", pageParams);
            this.$store.dispatch("getArticles");
        },
        createNavigation() {
            console.log("네비 사이즈1");
            console.log(this.navigationItem);
            this.navigationItem = [];
            console.log("네비 사이즈2");
            console.log(this.navigationItem);
            let params = this.$store.getters.pageParams;
            console.log({ params });
            http.get(`article/pageNavigation`, { params })
                .then((response) => {
                    console.log(response);
                    if (response.status != 200) {
                        alert("오류 발생" + response.status);
                        return;
                    }
                    this.lastPage = response.data.totalPageCount;
                    console.log("start : " + response.data.startPageNumber);
                    console.log("end : " + response.data.endPageNumber);
                    for (
                        let i = response.data.startPageNumber;
                        i <= response.data.endPageNumber;
                        i++
                    ) {
                        console.log("nav " + i);
                        this.navigationItem.push(i);
                    }
                })
                .catch(() => {
                    alert("오류 발생 ㅠ");
                });
        },
        created() {
            console.log("created");
        },
    },
};
</script>
