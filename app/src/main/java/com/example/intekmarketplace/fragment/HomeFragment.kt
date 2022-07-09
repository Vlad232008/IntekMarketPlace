package com.example.intekmarketplace.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.intekmarketplace.MainApp
import com.example.intekmarketplace.adapter.TovAdapter
import com.example.intekmarketplace.base.MainViewModel
import com.example.intekmarketplace.base.entities.BasketItem
import com.example.intekmarketplace.base.entities.TovItem
import com.example.intekmarketplace.databinding.FragmentNoteBinding
import kotlin.random.Random

class HomeFragment : Fragment(),TovAdapter.Listener {
    private lateinit var binding: FragmentNoteBinding
    private lateinit var adapter: TovAdapter
    private val mainViewModel: MainViewModel by activityViewModels {
        MainViewModel.MainViewModelFactory((context?.applicationContext as MainApp).database)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        insertTov()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        initRcView()
        observer()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    private fun initRcView() = with(binding){

        rcViewNote.layoutManager = GridLayoutManager(activity, 2)
        adapter = TovAdapter(this@HomeFragment)
        rcViewNote.adapter = adapter
    }


    private fun observer(){
        mainViewModel.allTovItem.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    private fun insertTov(){
        when (Random.nextInt(0, 3)) {
            0 -> {
                val table = TovItem(
                    null,
                    "Кейс со скоросшивателем для документов формата А4 голубой Berlin, замок бесцветный ПР20 СТАММ",
                    "- кейс для файлов предназначен для архивирования документов формата А4\n" +
                            "- позволяет хранить документы в вертикальном и горизонтальном положениях\n" +
                            "- надежно закрывается при помощи двух защелок\n" +
                            "- упаковка: пакет и цветной вкладыш\n" +
                            "- изготовлен из полипропилена\n" +
                            "- габариты 317х270х73мм",
                    393.09,
                    "Порт194"
                )
                mainViewModel.insertTov(table)
            }
            1-> {
                val door = TovItem(
                    null,
                    "Корзина  для бумаг  8л зелёная Pastel СТАММ КР161",
                    "Корзины предназначены  для утилизации и временного хранения бумаг. \n" +
                            "• Удобны в использовании и устойчивы.\n" +
                            "• Выполнены в оригинальном дизайне. \n" +
                            "• Изготовлены из сертифицированного пластика.",
                    182.11,
                    "Кор39"
                )
                mainViewModel.insertTov(door)
            }
            else -> {
                val room = TovItem(
                    null,
                    "Линейка 25см NEON ассорти СТАММ ЛН210",
                    "ровная четкая миллиметровая шкала\n" +
                            "• гладкая глянцевая поверхность\n" +
                            "• безопасные закругленные углы\n" +
                            "• индивидуальный штрих-код на единице изделия\n" +
                            "• сертифицированный полистирол\n" +
                            "• выпускается в коллек",
                    11.85,
                "Лин21"
                )
                mainViewModel.insertTov(room)
            }
        }

    }

    override fun addItemBasket(tov: TovItem) {
        val basketItem = BasketItem(
            null,
            tov.name,
            tov.price,
            1,
            tov.description,
            tov.invCode
        )
        mainViewModel.insertBasket(basketItem)
    }
}