<template>
    <div>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">글쓰기</h4>
                    <button type="button" class="close" data-dismiss="modal">
                        &times;
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group mr-sm-2">
                        <select class="form-control" id="selectOption">
                            <option value="FREE" selected>자유</option>
                            <option value="QNA">QnA</option>
                            <option
                                v-if="$store.state.session.admin == 1"
                                value="NOTICE"
                            >
                                공지 사항
                            </option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="subject">제목:</label>
                        <input
                            type="text"
                            class="form-control"
                            ref="subject"
                            id="subject"
                            v-model="subject"
                            name="subject"
                        />
                    </div>
                    <div class="form-group">
                        <label for="content">내용:</label>
                        <textarea
                            rows="8"
                            class="form-control"
                            ref="content"
                            id="content"
                            v-model="content"
                            name="content"
                        ></textarea>
                    </div>
                    <div class="text-center">
                        <button
                            type="button"
                            class="btn btn-primary"
                            @click="createHandler"
                        >
                            글작성
                        </button>
                        <button
                            type="button"
                            class="btn btn-secondary"
                            @click="moveHandler"
                        >
                            목록
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import http from "@/util/http-common";
import { mapGetters } from "vuex";
export default {
    data() {
        return {
            subject: "",
            content: "",
            articleType: "",
        };
    },
    computed: {
        ...mapGetters("session"),
    },
    methods: {
        createHandler() {
            let err = false;
            let msg = "";
            console.log(`subject: ${this.subject}, content: ${this.content}`);
            !err &&
                !this.subject &&
                ((msg = "제목을 입력해 주세요"),
                (err = false),
                this.$refs.subject.focus());
            !err &&
                !this.content &&
                ((msg = "내용을 입력해 주세요"),
                (err = false),
                this.$refs.content.focus());
            this.articleType = document.getElementById("selectOption").value;
            if (err) {
                alert(msg);
                return;
            }

            http.post("/board/write", {
                userId: this.$store.getters.session.userId,
                articleType: this.articleType,
                subject: this.subject,
                content: this.content,
            })
                .then(({ status }) => {
                    if (status == 200) {
                        alert("등록이 완료 됐습니다.");
                        this.moveHandler();
                    } else {
                        alert("등록 실패");
                    }
                })
                .catch(() => {
                    alert("error 발생");
                });
        },
        moveHandler() {
            this.$router.push("/happyhouse/article");
        },
        mounted() {
            this.$store.dispatch("getSession");
            console.log(this.$store.state.session);
        },
    },
};
</script>
