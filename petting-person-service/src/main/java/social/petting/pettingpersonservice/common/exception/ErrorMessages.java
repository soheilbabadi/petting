package social.petting.pettingpersonservice.common.exception;


public enum ErrorMessages {
    USER_NOT_EXIST("کاربری با این مشخصات وجود ندارد"),
    FILE_TOO_LARGE("فایل بزرگتر از حد مجاز است"),
    ROLE_NOT_EXIST("نقش مورد نظر در سیستم تعریف نشده است"),
    LOOKUP_NOT_EXIST("اطلاعات پایه درخواستی وجود ندارد"),
    INTERNAL_ERROR("خطایی در سرور رخ داده است"),
    AUTHENTICATION_FAIL("شما دسترسی کافی برای انجام این عملیات را ندارید"),
    DUPLICATE_DATA("اطلاعات وارده تکراری است"),
    RULE_NOT_FOUND("قانون مورد نظر وجود ندارد"),
    RULE_FILE_EXCEPTION("ساختار فایل drl صحیح نیست"),
    USER_LOCKED("کاربر مورد نظر قفل است"),
    USER_SUSPENDED("کاربر مورد نظر تعلیق شده است"),
    USER_DEACTIVATED("کاربر مورد نظر غیر فعال است"),
    EMAIL_ALREADY_EXISTS("ایمیل مورد نظر قبلا ثبت شده است"),
    USERNAME_ALREADY_EXISTS("نام کاربری مورد نظر قبلا ثبت شده است"),
    WRONG_PASSWORD("رمز عبور اشتباه است");

    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public ErrorMessages setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }
}