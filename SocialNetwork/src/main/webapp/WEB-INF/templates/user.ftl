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

            <a href="/post${post.id}">
            ${post.text}</a>

            <a href="/id${post.author.id}">
            ${post.author.firstName}
            ${post.author.lastName}
            </a>

        ${post.date}
        <br>
        </#list>
    </#if>

<form action="/id${user.id}/post" method="post">
    <div class="text-field">
        <input placeholder="Text here" css class="form-control" type="text" name="post">
    </div>
    <div class="form-group">
        <input class="btn btn-info btn-outline" type="submit" value="Send">
    </div>
</form>


</#macro>