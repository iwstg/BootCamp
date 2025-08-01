export default function Modal({ onClose, children }) {
  return (
    <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-[1000]" onClick={onClose}>
      <div className="bg-white rounded-lg w-[500px] max-w-[90%] shadow-lg overflow-hidden m-auto" onClick={(e) => e.stopPropagation()}>
        {children}
        <div className="flex flex-row-reverse w-full">
          <button className="p-3 mt-auto border-none text-2xl cursor-pointer" onClick={onClose}>X</button>        
        </div>
      </div>
    </div>
  );
}