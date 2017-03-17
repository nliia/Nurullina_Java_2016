<#include "menu.ftl">
<#macro content>
<title>Users</title>
    <#if users??><#list users as user>
    <h4><a href="/id${user.id}">${user.firstName} ${user.lastName}</a></h4>
    <br>
    </#list>
    </#if>
</#macro>