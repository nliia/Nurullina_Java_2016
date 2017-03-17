<#include "menu.ftl">
<#macro content>
Your chat with<a href="/id${user.id}"> ${user.firstName} ${user.firstName}</a>
    <#if messages ??>

        <#list messages as mes>
        ${mes.sender.firstName} ${mes.sender.lastName}
        ${mes.text}
        ${mes.date}
        <br>
        </#list>

    <#else>
    You will see here your messages
    </#if>

    <@sf.form role="form" action='/message${roomId}' method="post" modelAttribute="messageForm">
    <fieldset>

        <div class="field">
            <@sf.input placeholder="Text message" path="text" cssClass="form-control" type="text"/>
        </div>

        <div class="form-group">
            <input class="btn btn-info btn-outline" type="submit" value="Send">
        </div>

    </fieldset>
    </@sf.form>
</#macro>