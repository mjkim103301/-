<template>
    <div>
        <h4 class="text-center">게시글 수정</h4>
        <table class="table table-condensed w-25">
            <tr>
                <th>제목</th>
                <td>
                    <input
                        type="text"
                        id="subject"
                        ref="subject"
                        placeholder="제목을 입력해주세요"
                        v-model="article.subject"
                    />
                </td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                    <textarea
                        id="content"
                        cols="30"
                        rows="10"
                        ref="content"
                        v-model="article.content"
                    ></textarea>
                </td>
            </tr>
        </table>

        <div class="text-right">
            <button class="btn btn-primary" @click="updateHandler">수정</button>
            <button class="btn btn-primary" @click="moveHandler">목록</button>
        </div>
    </div>
</template>
<script>
import axios from "axios";
import { mapGetters } from "vuex";
export default {
    computed: {
        ...mapGetters(["article"]),
    },
    methods: {
        updateHandler: function () {
            let err = true;
            let msg = "";
            //필수 요건 검사
            err &&
                !this.article.subject &&
                ((msg = "제목을 입력해 주세요"),
                (err = false),
                this.$refs.subject.focus());
            err &&
                !this.article.content &&
                ((msg = "내용을 입력해 주세요"),
                (err = false),
                this.$refs.content.focus());

            if (!err) alert(msg);
            else {
                axios
                    .put(`http://localhost:9000/happyhouse/article/update`, {
                        articleId: this.article.articleId,
                        articleType: this.article.articleType,
                        subject: this.article.subject,
                        content: this.article.content,
                        hit: this.article.hit,
                        userId: this.article.userId,
                    })
                    .then(({ status }) => {
                        //console.log(`update: `, response)
                        if (status == 200) {
                            console.log("update................", status);
                            alert("수정 완료!!!");
                            this.moveHandler();
                        } else {
                            alert("수정 중 오류 발생 data: ", status);
                        }
                    })

                    .catch(() => {
                        alert("오류 발생");
                    });
            } // else end
        }, //function end
        moveHandler: function () {
            this.$router.push("/happyhouse/article");
        },
    },
};
</script>
