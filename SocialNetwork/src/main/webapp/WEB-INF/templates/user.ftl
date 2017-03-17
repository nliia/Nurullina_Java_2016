<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "menu.ftl">
<#macro content>

<title>${user.firstName} ${user.lastName}</title>

<h4>${user.firstName}</h4>
<h4>${user.lastName}</h4>
<h4>${user.email}</h4>
<h4><a href="/chat${user.id}">Send message</a></h4>

<h3>Posts</h3>
    <#if posts ??>
        <#list posts as post>
        <div class="col-md-4 col-lg-4 col-sm-6 col-xs-12">

            <a href="/post${post.id}">
            ${post.text}</a>

            <a href="/id${post.author.id}">
            ${post.author.firstName}
            ${post.author.lastName}
            </a>

        ${post.date}
        </div>
        <br>
        </#list>
    </#if>
    <@sf.form role="form" action='/id${user.id}/post' method="post" modelAttribute="postForm">
    <fieldset>

        <div class="field">
            <@sf.input placeholder="Text here..." path="text" cssClass="form-control" type="text"/>
        </div>

        <div class="form-group">
            <input class="btn btn-info btn-outline" type="submit" value="Send">
        </div>

    </fieldset>

    </@sf.form>


</#macro>