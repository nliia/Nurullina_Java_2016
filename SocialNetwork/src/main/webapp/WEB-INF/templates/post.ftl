<#include "menu.ftl">

<title>Post</title>

<#macro content>

<div class="col-md-4">

    <a href="/id${post.author.id}">
    ${post.author.firstName} ${post.author.lastName}
    </a>

${post.text}

${post.date}
    <br>

    <h4>Comments</h4>

    <form action="/post${post.id}" method="post">
        <div class="text-field">
            <input type="text" placeholder="Add your comment" name="comment" class="form-control">
        </div>

        <div class="form-group">
            <input class="btn btn-info" type="submit" value="Send">
        </div>
    </form>

    <#list comments as comment>
        <a href="/id${comment.author.id}">
        ${comment.author.firstName} ${comment.author.lastName}
        </a>
        <br>
    ${comment.text}
    ${comment.date}
    </#list>
</div>
</#macro>