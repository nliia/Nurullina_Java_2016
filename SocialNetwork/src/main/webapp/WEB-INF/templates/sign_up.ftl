<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "menu.ftl">
<#macro content>
<title>Sign up</title>

<a href="/sign_in">Sign in</a>

    <@sf.form action="/sign_up" method="post" modelAttribute="user">
    <fieldset>
        <div class="field" style="width: 20%">
            <@sf.label path="firstName">First name</@sf.label>
            <@sf.input path="firstName" type="text" cssClass="form-control"/>
            <@sf.errors path="firstName"/>
        </div>
        <div class="field" style="width: 20%">
            <@sf.label path="lastName">Last name</@sf.label>
            <@sf.input path="lastName" type="text" cssClass="form-control"/>
            <@sf.errors path="lastName"/>
        </div>
        <div class="field" style="width: 20%">
            <@sf.label path="email">Email</@sf.label>
            <@sf.input path="email" type="email" cssClass="form-control"/>
            <@sf.errors path="email"/>
        </div>
        <div class="field" style="width: 20%">
            <@sf.label path="password">Password</@sf.label>
            <@sf.input path="password" type="password" cssClass="form-control"/>
            <@sf.errors path="password"/>
        </div>

        <div>
            <input type="submit" value="Sign up">
        </div>
    </fieldset>
    </@sf.form>
</#macro>