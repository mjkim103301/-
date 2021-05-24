<template>
    <div>
        <section id="" class="p-1">
            <div class="container">
                <div class="mb-2"></div>
                <div class="p-2 mb-5">
                    <table class="table table-hover">
                        <h4>댓글</h4>
                        <tbody v-if="replies.length > 0">
                            <tr v-for="(reply, index) in replies" :key="index">
                                <td>{{ reply.userId }}</td>
                                <td>{{ reply.content }}</td>
                                <td>{{ reply.registerTime | toDate }}</td>
                                <button
                                    class="btn ptn-primary"
                                    @click="removeReplyHandler(reply)"
                                >
                                    삭제
                                </button>
                            </tr>
                        </tbody>
                    </table>

                    <div class="form-group">
                        <label for="content"></label>
                        <textarea
                            rows="2"
                            class="form-control"
                            ref="content"
                            id="content"
                            v-model="content"
                            name="content"
                            @keydown.enter="createReplyHandler"
                        ></textarea>
                    </div>
                    <div class="text-center">
                        <button
                            type="button"
                            class="btn btn-primary"
                            @click="createReplyHandler"
                        >
                            댓글 작성
                        </button>
                    </div>
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
import http from "@/util/http-common";
export default {
    name: "replyList",
    data() {
        return {
            content: "",
            page: 1,
            lastPage: 1,
            navigationItem: [],
        };
    },
    computed: {
        ...mapGetters(["replies", "article", "session"]),
    },
    filters: {
        toDate: function (regtime) {
            return moment(new Date(regtime)).format("YY.M.D H시 mm분");
        },
    },
    methods: {
        removeReplyHandler(reply) {
            http.delete(
                `board/${this.$route.params.articleId}/reply/${reply.replyId}`
            )
                .then(({ status }) => {
                    if (status != 200) {
                        alert("에러 ! ");
                        return;
                    }
                    this.listReply();
                    this.createNavigation();
                })
                .catch(() => {
                    alert("에러 ! ");
                });
        },
        movePageHandler(page) {
            this.page =
                page > this.lastPage ? this.lastPage : page < 1 ? 1 : page;
            console.log(page + " " + this.lastPage);
            console.log(this.page);
            this.listReply();
            this.createNavigation();
        },
        createReplyHandler() {
            console.log("createReply");
            if (!this.content && this.content.trim() == "") {
                alert("내용 입력 !");
                return;
            }
            this.createReply();
        },
        createReply() {
            http.post(`board/${this.$route.params.articleId}/reply`, {
                userId: "ssafy",
                articleId: `${this.$route.params.articleId}`,
                content: this.content,
            })
                .then(({ status }) => {
                    console.log(status);
                    if (status != 200) {
                        alert("오류 발생");
                        return;
                    }
                    this.content = "";
                    this.listReply();
                    this.createNavigation();
                })
                .catch(() => {
                    alert("오류 발생 ㅠ");
                });
        },
        createNavigation() {
            this.navigationItem = [];
            http.get(
                `board/${this.$route.params.articleId}/reply/${this.page}/navigation`
            )
                .then((response) => {
                    console.log(response);
                    if (response.status != 200) {
                        alert("오류 발생");
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
                        this.navigationItem.push(i);
                    }
                })
                .catch(() => {
                    alert("오류 발생 ㅠ");
                });
        },

        listReply() {
            console.log(
                `/board/${this.$route.params.articleId}/reply/${this.page}`
            );
            this.$store.dispatch(
                "getReplies",
                `/board/${this.$route.params.articleId}/reply/${this.page}`
            );
        },
    },
    created() {
        console.log("ReplyList created" + `${this.$route.params.articleId}`);
        this.$store.dispatch("getSession");
        this.listReply();
        this.createNavigation();
    },
};
</script>
