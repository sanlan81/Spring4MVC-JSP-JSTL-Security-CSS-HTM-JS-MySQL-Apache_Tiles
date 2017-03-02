function doAjax() {
    $.ajax({
        url: '/checkStrength',
        data: {
            password: $('#password').val()
        },
        success: function (data) {
            var strength = data.strength;
            if (!strength) {
                $('#strengthValue').html('').removeClass();
            } else {
                $('#strengthValue').html(strength)
                    .removeClass()
                    .addClass(strength);
            }
        }
    });
}