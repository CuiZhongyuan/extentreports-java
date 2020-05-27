<nav>
	<div class="nav-wrapper">
		<a href="#!" class="brand-logo blue darken-3">Extent</a>

		<!-- slideout menu -->
		<ul id='slide-out' class='side-nav fixed hide-on-med-and-down'>
			<li class='waves-effect active'><a href='#!' view='test-view' onclick="configureView(0);chartsView('test');"><i class='material-icons'>dashboard</i></a></li>
			<#if categoryContext?? && categoryContext?size != 0>
			<li class='waves-effect'><a href='#!' view='category-view' onclick="configureView(1)"><i class='material-icons'>label_outline</i></a></li>
			</#if>
			<#if authorContext?? && authorContext?size != 0>
				<li class='waves-effect'><a href='#!' view='author-view' onclick="configureView(3)"><i class='material-icons'>person</i></a></li>
			</#if>
			<#if exceptionContext?? && exceptionContext?size != 0>
			<li class='waves-effect'><a href='#!' view='exception-view' onclick="configureView(2)"><i class='material-icons'>bug_report</i></a></li>
			</#if>
			<li class='waves-effect'><a href='#!' onclick="configureView(-1);chartsView('dashboard');" view='dashboard-view'><i class='material-icons'>track_changes</i></i></a></li>
			<#if report.testRunnerLogs?? && report.testRunnerLogs?size != 0>
			<li class='waves-effect'><a href='#!' onclick="configureView(-1)" view='testrunner-logs-view'><i class='material-icons'>note</i></a></li>
			</#if>
		</ul>

		<!-- report name -->
		<span class='report-name'>${ config.getValue('reportName') }</span>
		
		<!-- report headline -->
		<span class='report-headline'></span>

		<!-- nav-right -->
		<ul id='nav-mobile' class='right hide-on-med-and-down nav-right'>
			<li>
                <a href='#!'>
                    <span class='label suite-start-time blue darken-3'>${ report.startTime?datetime?string["${timeStampFormat}"] }</span>
				</a>
			</li>
			<li>
                <a href='#!'>
                    <span class='label blue darken-3'>3.1.5</span>
				</a>
			</li>
		</ul>
	</div>
</nav>
