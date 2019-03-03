<div class="container">
	<div class="row">
		<!-- Sidebar Content -->
		<div class="col-md-3">
			<%@include file="./master/sidebar.jsp" %>
		</div>
		
		<!-- to display actual products -->
		<div class="col-md-9">
			<!-- Added bread crumb component -->
			<div class="row">
				<div class="col-md-12">
					<ul class="breadcrumb mt-4">
						
						<li><a href="${contextRoot}/home" >Home </a></li>
						<li class="active">  Category</li>
						<li class="active">  ${category.name}</li>
						
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>