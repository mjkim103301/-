<template>
    <div>
        <section id="" class="">
            <div class="">
                <div class="mb-2"></div>
                <div class="mb-5">
                    <table class="table table-striped">
                        <h4>댓글</h4>
                        <tbody v-if="replies.length > 0">
                            <!-- <tr>
                                <th style="width: 20%"></th>
                                <th style="width: 60%"></th>
                                <th style="width: 20%"></th>
                            </tr> -->
                            <tr v-for="(reply, index) in replies" :key="index">
                                <td style="width: 15%">
                                    <span
                                        v-if="reply.userCampus == 'ADMIN'"
                                        class="badge badge-danger"
                                        >프로</span
                                    >
                                    <span
                                        v-if="reply.userCampus == '서울'"
                                        class="badge badge-warning"
                                        >서울</span
                                    >
                                    <span
                                        v-if="reply.userCampus == '대전'"
                                        class="badge badge-success"
                                        >대전</span
                                    >
                                    <span
                                        v-if="reply.userCampus == '광주'"
                                        class="badge badge-info"
                                        >광주</span
                                    >
                                    <span
                                        v-if="reply.userCampus == '구미'"
                                        class="badge badge-primary"
                                        >구미</span
                                    >
                                    <span
                                        v-if="
                                            !reply.userCampus ||
                                            reply.userCampus.length == 0
                                        "
                                        class="badge badge-secondary"
                                        >손님</span
                                    >
                                    {{ reply.userId }}
                                </td>
                                <td style="width: 65%">{{ reply.content }}</td>
                                <td style="width: 15%">
                                    {{ reply.registerTime | toDate }}
                                </td>
                                <td style="width: 5%">
                                    <button
                                        v-if="
                                            session.userId == reply.userId ||
                                            (session.admin &&
                                                session.admin == 1)
                                        "
                                        class="btn"
                                        @click="removeReplyHandler(reply)"
                                    >
                                        ❌
                                    </button>
                                </td>
                            </tr>
                        </tbody>
                    </table>

                    <div
                        v-if="session.userId && session.userId.length != 0"
                        class="form-group row p-1"
                    >
                        <textarea
                            rows="2"
                            class="form-control col-sm-9 ml-3"
                            ref="content"
                            id="content"
                            v-model="content"
                            name="content"
                            @keydown.enter="createReplyHandler"
                        ></textarea>
                        <button
                            type="button"
                            class="btn btn-info pull-right ml-2 col-sm-2"
                            @click="createReplyHandler"
                        >
                            댓글 작성
                        </button>
                    </div>
                </div>
                <div class="mt-3">
                    <ul class="pagination justify-content-center">
                        <li class="page-item">
                            <a
                                class="page-link text-info"
                                @click="movePageHandler(1)"
                                >최신</a
                            >
                        </li>
                        <li class="page-item">
                            <a
                                class="page-link text-info"
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
                                class="page-link text-light bg-info"
                                @click="movePageHandler(nav)"
                                >{{ nav }}</a
                            >
                            <a
                                v-else
                                class="page-link text-info"
                                @click="movePageHandler(nav)"
                                >{{ nav }}</a
                            >
                        </li>

                        <li class="page-item">
                            <a
                                class="page-link text-info"
                                @click="movePageHandler(page + 5)"
                                >다음</a
                            >
                        </li>
                        <li class="page-item">
                            <a
                                class="page-link text-info"
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
            return moment(new Date(regtime)).format("YY-M-D H:mm");
        },
    },
    methods: {
        removeReplyHandler(reply) {
            http.delete(
                `article/${this.$route.params.articleId}/reply/${reply.replyId}`
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
            http.post(`article/${this.$route.params.articleId}/reply`, {
                userId: `${this.$store.getters.session.userId}`,
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
                `article/${this.$route.params.articleId}/reply/${this.page}/navigation`
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
                `/article/${this.$route.params.articleId}/reply/${this.page}`
            );
            this.$store.dispatch(
                "getReplies",
                `/article/${this.$route.params.articleId}/reply/${this.page}`
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
