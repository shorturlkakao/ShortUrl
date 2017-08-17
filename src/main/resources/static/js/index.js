var shorturl = shorturl || {};
(function ($) {
    "use strict"
    shorturl.create = shorturl.create || {
        $url_text: $('#fullurl'),
        $error_txt: $('#errormsg'),
        $create_btn: $('#createBtn'),
        $reset_btn: $('#resetBtn'),
        $pn_success: $('#pnl_success'),
        $pn_fail: $('#pnl_fail'),
        _domain: 'http://localhost:8080/',
        _crateUrl: 'short-url',
        init: function () {
            this.$create_btn.click($.proxy(this.createUrl, this));
            this.$reset_btn.click($.proxy(this.reset, this));

        },
        createUrl: function () {
            if (!this.$url_text.val()) {
                alert("변환할 url을 입력하세요.");
                return;
            }
            $('#pnl_success').hide();
            $('#pnl_fail').hide();
            var that = this;
            $.ajax({
                url: that._crateUrl,
                dataType: 'json',
                type: 'post',
                timeout: 3000,
                async: true,
                data: {
                    'url': $('#fullurl').val()
                },
                success: function (response) {
                    // alert(JSON.stringify(result, null, 4));
                    if (response && response.result) {
                        that.$pn_success.fadeIn(300);
                        $('#result').val(that._domain + response.data.shortUrl);
                    } else {
                        that.$pn_fail.fadeIn(300);
                        that.$error_txt.val(response.error);
                    }

                },
                error: function (request, status, error) {
                    that.$pn_fail.fadeIn(300);
                }
            });
        },
        reset: function () {
            this.$url_text.val("");
            this.$pn_success.fadeOut(150);
            this.$pn_fail.fadeOut(150);
        }
    };
    $(function () {
        shorturl.create.init();
    });
}(jQuery));