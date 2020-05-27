<#assign timeStampFormat = config.getValue('timeStampFormat')>
<#assign cdn = config.getValue('cdn')>

<head>
	<meta charset='${ config.getValue('encoding') }' /> 
	<meta name='description' content='' />
	<meta name='robots' content='noodp, noydir' />
	<meta name='viewport' content='width=device-width, initial-scale=1' />
	<meta id="timeStampFormat" name="timeStampFormat" content='${timeStampFormat}'/>
	
	<link href='${ config.getValue('protocol') }://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600' rel='stylesheet' type='text/css' />
	<link href="${ config.getValue('protocol') }://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />

	<#if cdn == 'extentreports'>
		<link href='./css/extent.css' type='text/css' rel='stylesheet' />
	<#else>
		<link href='${ config.getValue('protocol') }://cdn.rawgit.com/anshooarora/extentreports-java/b4a58fcfd1e137bd9287244035a7c80d3d73b3af/dist/css/extent.css' type='text/css' rel='stylesheet' />
	</#if>
	
	<title>${ config.getValue('documentTitle') }</title>

	<style type='text/css'>
		<#if config.containsKey('css')>
			${ config.getValue('css') }
		</#if>
		<#if config.containsKey('styles')>
			${ config.getValue('styles') }
		</#if>
	</style>
</head>
