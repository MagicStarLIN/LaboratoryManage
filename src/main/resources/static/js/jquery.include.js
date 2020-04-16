jQuery.fn.extend({
    include: function (path) {
        var _this = $(this);

        $.get(path, function (html) {
            _this.replaceWith(html);
        });

        return 0;
    }
});