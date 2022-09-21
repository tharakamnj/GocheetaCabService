	<!-- partial:partials/_navbar.html -->
			<nav class="navbar">
				<a href="#" class="sidebar-toggler">
					<i data-feather="menu"></i>
				</a>
				<div class="navbar-content">
					<form class="search-form">
						<div class="input-group">
							<div class="input-group-prepend">
								<div class="input-group-text">
									<i data-feather="search"></i>
								</div>
							</div>
							<input type="text" class="form-control" id="navbarForm" placeholder="Search here...">
						</div>
					</form>
					<ul class="navbar-nav">
					<li class="nav-item dropdown nav-notifications">
						<a class="nav-link dropdown-toggle" href="#" id="notificationDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<i data-feather="bell"></i>
							<div class="indicator">
								<div class="circle"></div>
							</div>
						</a>
						<div class="dropdown-menu" aria-labelledby="notificationDropdown">
							<div class="dropdown-header d-flex align-items-center justify-content-between">
								<p class="mb-0 font-weight-medium">6 New Notifications</p>
								<a href="javascript:;" class="text-muted">Clear all</a>
							</div>
							<div class="dropdown-body">
								<a href="javascript:;" class="dropdown-item">
									<div class="icon">
										<i data-feather="user-plus"></i>
									</div>
									<div class="content">
										<p>New customer registered</p>
										<p class="sub-text text-muted">2 sec ago</p>
									</div>
								</a>
								<a href="javascript:;" class="dropdown-item">
									<div class="icon">
										<i data-feather="gift"></i>
									</div>
									<div class="content">
										<p>New Order Recieved</p>
										<p class="sub-text text-muted">30 min ago</p>
									</div>
								</a>
								<a href="javascript:;" class="dropdown-item">
									<div class="icon">
										<i data-feather="alert-circle"></i>
									</div>
									<div class="content">
										<p>Server Limit Reached!</p>
										<p class="sub-text text-muted">1 hrs ago</p>
									</div>
								</a>
								<a href="javascript:;" class="dropdown-item">
									<div class="icon">
										<i data-feather="layers"></i>
									</div>
									<div class="content">
										<p>Apps are ready for update</p>
										<p class="sub-text text-muted">5 hrs ago</p>
									</div>
								</a>
								<a href="javascript:;" class="dropdown-item">
									<div class="icon">
										<i data-feather="download"></i>
									</div>
									<div class="content">
										<p>Download completed</p>
										<p class="sub-text text-muted">6 hrs ago</p>
									</div>
								</a>
							</div>
							<div class="dropdown-footer d-flex align-items-center justify-content-center">
								<a href="javascript:;">View all</a>
							</div>
						</div>
					 </li>
					<li class="nav-item dropdown nav-profile">
							<a class="nav-link dropdown-toggle" href="#" id="profileDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<img src="https://via.placeholder.com/30x30" alt="userr">
							</a>
							<div class="dropdown-menu" aria-labelledby="profileDropdown">
								<div class="dropdown-header d-flex flex-column align-items-center">
									<div class="figure mb-3">
										<img src="https://via.placeholder.com/80x80" alt="">
									</div>
									<div class="info text-center">
										<p class="name font-weight-bold mb-0"><%= session.getAttribute("UserDisplayName") %></p>
										<p class="email text-muted mb-3"><%= session.getAttribute("UserContact") %></p>
									</div>
								</div>
								<div class="dropdown-body">
									<ul class="profile-nav p-0 pt-3">
										
										<!-- <li class="nav-item">
											<a href="javascript:;" class="nav-link">
												<i data-feather="edit"></i>
												<span>Edit Password</span>
											</a>
										</li> -->
										
										<li class="nav-item">
											<a href="LoginControllerServlet" class="nav-link">
												<i data-feather="log-out"></i>
												<span>Log Out</span>
											</a>
										</li>
									</ul>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</nav>
			<!-- partial -->