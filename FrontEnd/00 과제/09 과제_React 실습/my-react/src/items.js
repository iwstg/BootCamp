export default function(props){
    console.log("가져온 정보:", props);
    return (
        <div className="col-sm-6 align-items-start justify-content-start mb-1">
            <div className="card mb-3">
                <div className="row g-0">
                    <div className="col-md-5">
                        <img src={props.img_src} alt="내이미지" className="img-fluid h-100 border"></img>
                    </div>
                    <div className="col-md-7">
                        <div className="card-body p-1 d-flex flex-column justify-content-between text-start h-100">
                            <p className="card-text mb-1" style= {{ fontSize: '0.875rem' }}>{props.title}</p>
                            <p className="card-title my-1" style= {{ fontSize: '1rem', fontWeight: 'bold' }}>{props.price}</p>
                            <p className="text-body-secondary mt-auto mb-0" style= {{ fontSize: '0.75rem' }}>{props.company}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}