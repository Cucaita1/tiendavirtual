package com.example.tiendavirtual.fragments

    import android.os.Bundle
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.Button
    import androidx.fragment.app.Fragment
    import androidx.navigation.fragment.findNavController
    import com.example.tiendavirtual.R

class InicioFragment : Fragment(){

    private lateinit var botonproductos: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_inicio, container, false)
        botonproductos = view.findViewById(R.id.botonproductos)

        botonproductos.setOnClickListener{
            findNavController().navigate(R.id.ProdcutosFragment)
        }

        return view
    }



}