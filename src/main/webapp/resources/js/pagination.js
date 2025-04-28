document.addEventListener('DOMContentLoaded', ()=> {
	
	const searchForm = document.getElementById('searchForm')
	const pageInput = document.getElementById('pageInput')
	const sizeInput = document.getElementById('sizeInput')
	const sizeSelect = document.getElementById('sizeSelect')
	
	if(searchForm && pageInput && sizeInput){
		
		sizeSelect.addEventListener('change', ()=>{
			sizeInput.value = sizeSelect.value
			pageInput.value = '0'
			searchForm.submit()
		})
		
		Array.from(document.getElementsByClassName('pageLink')).forEach(pageLink => {
					pageLink.addEventListener('click', (event) => {
						event.preventDefault()
						pageInput.value = pageLink.dataset['pageNumber']
						searchForm.submit()
					})
				})	
		
	}
	
	
	
})