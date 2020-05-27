<#list test.nodeContext.all as node>
<div class='${ node.getBehaviorDrivenType().getSimpleName()?lower_case } node' test-id='${ node.getID() }' status='${ node.status }'>
	<#if node.hasCategory()>
	<div class='category-list'>
		<#list node.categoryContext.all as category>
		<span class='category label white-text'>${ category.name }</span>
		</#list>
	</div>
	</#if>
	<span class='duration right label'>${ node.runDuration }</span>
	<div class='desc'>
		<b>${ node.getBehaviorDrivenType().getSimpleName() }</b>
		<span class="desc-text">${ node.name }</span>
		<#if node.screenCaptureList?? && node.screenCaptureList?size != 0>
		<ul class='screenshots right'>
			<#list node.screenCaptureList as sc>
			<li><a data-featherlight="image" href="${ sc.path }"><i class='material-icons'>panorama</i></a></li>
			</#list>
		</ul>
		</#if>
		<#if node.description?? && node.description?has_content>
		<div class='pre'>${ node.description }</div>
		</#if>
	</div>
	<#if node.hasChildren()>
	<ul class='steps'>
		<#list node.nodeContext.all as child>
		<li test-id='${ child.getID() }' class='node ${ child.getBehaviorDrivenType().getSimpleName()?lower_case } ${ child.status }' status='${ child.status }'>
			<#if child.hasCategory()>
			<div class='category-list'>
				<#list child.categoryContext.all as category>
				<span class='category label white-text'>${ category.name }</span>
				</#list>
			</div>
			</#if>
			
			<b>${ child.getBehaviorDrivenType().getSimpleName()?string }</b>
			
			<span class="bdd-step-name">${ child.name }</span>
			<#if child.screenCaptureList?? && child.screenCaptureList?size != 0>
			<ul class='screenshots right'>
				<#list child.screenCaptureList as sc>
				<li><a data-featherlight="image" href="${ sc.path }"><i class='material-icons'>panorama</i></a></li>
				</#list>
			</ul>
			</#if>
			<#if child.description?? && child.description?has_content>
			<div class='pre'>${ child.description }</div>
			</#if>
			<#list child.logContext.all as log>
				<div class='pre'>${ log.details }</div>
			</#list>
			
			<#if child.hasChildren()>
				<ul class='steps'>
				<#list child.nodeContext.all as grandchild>
					<li test-id='${ grandchild.getID() }' class='node ${ grandchild.getBehaviorDrivenType().getSimpleName()?lower_case } ${ grandchild.status }' status='${ grandchild.status }'><b>${ grandchild.getBehaviorDrivenType().getSimpleName()?string }</b>
						<span class="bdd-step-name">${ grandchild.name }</span>
						<#if grandchild.screenCaptureList?? && grandchild.screenCaptureList?size != 0>
						<ul class='screenshots right'>
							<#list grandchild.screenCaptureList as sc>
							<li><a data-featherlight="image" href="${ sc.path }"><i class='material-icons'>panorama</i></a></li>
							</#list>
						</ul>
						</#if>
						<#if grandchild.description?? && grandchild.description?has_content>
						<div class='pre'>${ grandchild.description }</div>
						</#if>
						<#list grandchild.logContext.all as log>
							<div class='pre'>${ log.details }</div>
						</#list>
					</li>
				</#list>
				</ul>
			</#if>
		</li>
		</#list>
	</ul>
	</#if>
</div>
</#list>