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

    <@sf.form role="form" action='/post${post.id}' method="post" modelAttribute="commentForm">
        <fieldset>

            <div class="field">
                <@sf.input placeholder="Add your comment" path="text" cssClass="form-control" type="text"/>
            </div>

            <div class="form-group">
                <input class="btn btn-info btn-outline" type="submit" value="Send">
            </div>

        </fieldset>

    </@sf.form>
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