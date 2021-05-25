<template>
    <div>삭제중...</div>
</template>
<script>
import http from "@/util/http-common.js";
export default {
    methods: {
        moveHandler: function () {
            this.$router.push("/happyhouse/article");
        },
    },
    created() {
        const articleId = this.$route.params.articleId;
        console.log("remove.............", articleId);
        http.delete(`article/${articleId}`)
            .then(({ status }) => {
                //console.log(`remove.vue response `, response)
                if (status == 200) {
                    alert("삭제 완료!!!");
                    this.moveHandler();
                } else {
                    alert("삭제중 오류 발생");
                    this.$router.push(`/happyhouse/article/${articleId}`);
                }
            })
            .catch(() => {
                alert("오류 발생");
                this.$router.push(`/happyhouse/article/${articleId}`);
            });
    },
};
</script>
