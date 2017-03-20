<#include "menu.ftl">
<#macro content>
Your chat with<a href="/id${user.id}"> ${user.firstName} ${user.lastName}</a>
<br>
    <#if messages ??>

        <#list messages as mes>
        <h5><a href="/id${mes.sender.id}">${mes.sender.firstName} ${mes.sender.lastName}</a>  ${mes.text} ${mes.date}</h5>
        <br>
        </#list>

    <#else>
    You will see here your messages
    </#if>

<form action="/message${roomId}" method="post">
    <div class="text-field">
        <input placeholder="Text message" class="form-control" type="text" name="message">
    </div>
    <input type="hidden" value="${user.id}" name="userId"/>
    <div class="form-group">
        <input class="btn btn-info btn-outline" type="submit" value="Send">
    </div>
</form>
</#macro>