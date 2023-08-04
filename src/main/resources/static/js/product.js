const counters = document.querySelectorAll('[data-counter]');

if(counters){
    counters.forEach(counter => {
        counter.addEventListener('click', e => {
            const target = e.target;

            if (target.closest('.counter__button')){
                let value = parseInt(target.closest('.counter').querySelector('input').value);
                let product_id = target.closest('.counter').querySelector('input').id;
                let balance = parseFloat(document.getElementById("balance_" + product_id).innerHTML);
                if (target.classList.contains('counter__button_plus')){
                    value++;
                } else{
                    -- value;
                }
                
                if(value < 1) {
                    value = 1;
                } else if (value > balance){
                    value = balance;
                }
                
                target.closest('.counter').querySelector('input').value = value;
                
            }
        })
    })
}

function get_id_name(id){
    return "balance_" + id;
}

