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
                            </tr>
                        </tbody>
                    </table>

                    <form class="form-inline float-right">
                        <div class="form-group mr-sm-2">
                            <input
                                type="text"
                                class="form-control"
                                id="searchKey"
                            />
                        </div>
                        <button type="submit" class="btn btn-secondary">
                            작성
                        </button>
                    </form>
                </div>
                <div class="mt-3">
                    <ul class="pagination justify-content-center">
                        <li class="page-item">
                            <a class="page-link" href="#">최신</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="#">이전</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="#">1</a>
                        </li>
                        <li class="page-item active">
                            <a class="page-link" href="#">2</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="#">3</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="#">다음</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="#">마지막</a>
                        </li>
                    </ul>
                </div>
            </div>
        </section>
    </div>
</template>
<script>
// import http from '@/util/http-common.js'
import moment from "moment";
import { mapGetters } from "vuex";
export default {
    name: "replyList",
    computed: {
        ...mapGetters(["replies", "article"]),
    },
    filters: {
        toDate: function (regtime) {
            return moment(new Date(regtime)).format("YYYY.MM.DD.HH.MM");
        },
    },
    methods: {
        movePage() {
            this.$router.push("/article/write");
        },
    },
    created() {
        console.log("ReplyList created" + `${this.$route.params.articleId}`);
        this.$store.dispatch(
            "getReplies",
            `/board/${this.$route.params.articleId}/reply/1`
        );
    },
};
</script>
