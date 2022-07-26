import java.util.Scanner;
class AnimalDAO 
{
	AnimalDB db = new AnimalDB();
	AnimalDTO dto[] = new AnimalDTO[db.petInfo.length];
	AnimalDTO dto2[] = new AnimalDTO[db.hospiInfo.length];
	public void dtoSet(){
		for ( int i = 0 ; i < db.petInfo.length ; i++ ){
			dto[i] = new AnimalDTO();
			dto[i].setPetNum(db.petInfo[i][0]);
			dto[i].setPetName(db.petInfo[i][1]);
			dto[i].setPetSp(db.petInfo[i][2]);
			dto[i].setPetKind(db.petInfo[i][3]);
			dto[i].setPetSex(db.petInfo[i][4]);
			dto[i].setPetAge(db.petInfo[i][5]);
			dto[i].setPetWeight(db.petInfo[i][6]);
			dto[i].setPetVideo(db.petInfo[i][7]);
		}
		for ( int j = 0 ; j < db.hospiInfo.length ; j ++ )
		{
			dto2[j] = new AnimalDTO();
			dto2[j].setHospiName(db.hospiInfo[j][1]);
			dto2[j].setHospiAdd(db.hospiInfo[j][0]);
		}
	}
	public void mLine( char a, int b){      // 라인 그리기
		for ( int i = 0 ; i < b; i ++ )
		{
			System.out.print(a);
		}
		System.out.println();
	}
	public void change(){					//성별 한글로 변환
		for ( int i = 0 ; i < db.petInfo.length ; i++ )
		{
			if ( dto[i].getPetSex() == "M")
			{
				dto[i].setPetSex("남아");
			}
			if ( dto[i].getPetSex() == "W")
			{
				dto[i].setPetSex("여아");
			}
		}
	}

	public void intro(){			//메뉴 출력 1.강아지 입양 2.고양이 입양 3. 보호중 동물 목록 4.동물병원 추천 5.찾아오시는 길
		System.out.println("\t\t♡서울동물복지지원센터♡");
		mLine('=',70);
		System.out.println("\t\t1.강아지 입양\n\t\t2.고양이 입양\n\t\t3.보호중 동물 목록\n\t\t4.동물병원 추천\n\t\t5.찾아오시는 길\n\t\t0.종료");
		mLine('=',70);
		System.out.print("\t\t메뉴를 선택해 주세요 >> ");
		Scanner scann = new Scanner(System.in);
		String sc = scann.nextLine();
		int num = Integer.parseInt(sc);
		switch (num)
		{
		case 1: { 
			dog();
		}
			break;
		case 2: {
			cat();
		}
			break;
		case 3:{
			petList();
		}
		 break;
		case 4:{
			while (true)
			{
				hospiRecommend();
			}
		}
		case 5:{
			place();
		}
		break;
		case 0:{
			exit();
		}
		break;
		default :{
				menuerror();
		}
		
		}
	}

	public void menuerror(){
		System.out.print("\t\t없는 메뉴 입니다 메뉴를 확인해주세요.\n");
		intro();
	}
	public void dog(){		   //강아지 입양
		mLine('-',70);
		System.out.println("\t\t1.강아지 목록 보기\n\t\t2.조건으로 검색\n\t\t3.메인메뉴로\n\t\t0.종료");
		mLine('-',70);
		System.out.print("\t\t메뉴를 선택해 주세요 >> ");
		Scanner scann = new Scanner(System.in);
		String sc = scann.nextLine();
		int num = Integer.parseInt(sc);
		if (num == 1)
		{
			dogList();
			select();
		}
		if (num == 2)
		{
			mLine('-',70);
			System.out.println("\t\t1.품종 검색\n\t\t2.소형견만 검색\n\t\t3.중형견만 검색\n\t\t4.메인 메뉴로\n\t\t0.종료");
			mLine('-',70);
			System.out.print("\t\t메뉴를 선택해 주세요 >> ");
			String select = scann.nextLine();
			int num2 = Integer.parseInt(select);
			if (num2 == 1)
			{
				while (true)
				{
					spSearch();
				}
			
			}
			if (num2 == 2)
			{
				dogSize();
				select();
			}
			if (num2 ==3)
			{
				dogSize2();
				select();
			}
			if (num2 ==4)
			{
				intro();
			}
			if (num2 == 0)
			{
				exit();
			}
		
			
		}
		if (num == 3)
		{
			intro();
		}
		if (num ==0)
		{
			exit();
		}
		else {
			menuerror();
		}
	

	}
	public void cat(){		//고양이 입양
		mLine('-',70);
		System.out.println("\t\t1.고양이 목록 보기\n\t\t2.조건으로 검색\n\t\t3.메인메뉴로\n\t\t0.종료");
		mLine('-',70);
		System.out.print("\t\t메뉴를 선택해 주세요 >> ");
		Scanner scann = new Scanner(System.in);
		String sc = scann.nextLine();
		int num = Integer.parseInt(sc);
		if (num == 1)
		{
			catList();
			select();
		}
		if (num ==2)
		{
			mLine('-',70);
			System.out.println("\t\t1.품종 검색\n\t\t2.메인 메뉴로\n\t\t0.종료");
			mLine('-',70);
			System.out.print("\t\t메뉴를 선택해 주세요 >> ");
			String select = scann.nextLine();
			int num2 = Integer.parseInt(select);
			if (num2 == 1)
			{
				while (true)
				{
					spSearch();
				}
			
			}
			if (num2 ==2)
			{
				intro();
			}
			if (num2 == 0)
			{
				exit();
			}
			
		}
		if (num ==3)
		{
			intro();
		}
		if (num ==0)
		{
			exit();
		}
			else {
			menuerror();
		}
		

		}
	
	
	void hospiRecommend(){			// 병원 추천
		System.out.print("\t\t찾으시는 지역구를 입력하세요 >>");
		Scanner scann = new Scanner(System.in);
		String city = scann.nextLine();
		System.out.println("병원 이름\t\t\t병원주소");
		mLine('-',100);
		int flag = 0;
		for (int i = 0 ; i < db.hospiInfo.length ; i++ )
		{ 
			String a[];
		   a=db.hospiInfo[i][0].split(" ");
		  if (city.contains(a[1]))
			{
			  flag++;
			  System.out.printf("%-20s%-20s\n",dto2[i].getHospiName(),dto2[i].getHospiAdd());
			}
		   }
		 if (flag == 0)
			{
			System.out.println("찾으시는 지역에 병원이 없습니다");
			}
			else {
		   mLine('-',100);
		   System.out.println("[ 메인 메뉴로 : 1 ] [ 종료 : 0 ]");
		   String sc = scann.nextLine();
			int num = Integer.parseInt(sc);
			if ( num == 1)
			{
				intro();
			}
			if ( num == 0)
			{
				exit();
			}
			else {
				menuerror();
			}
			}
		}


		void exit(){   // 시스템 종료
			System.out.println(" 서울에서 발생하는 유기동물은 한해 약 6,500마리에 이르지만,\n그중 약 1/4은 새로운 보호자를 만나지 못해 안락사되고 있습니다.\n서울시는 ‘유기동물 안락사 제로화, 입양 100%’실현을 위하여,\n유기동물의 치료부터 입양, 교육까지 전담하는 동물보호 전문시설인\n서울동물복지지원센터 마포센터와 구로센터를 각각 2017년 10월과\n2020년 4월부터 운영하여 시민 여러분께 건강한 반려동물이 입양\n되도록 힘쓰고 있습니다. 앞으로 유기동물 입양이 우리 사회의\n보편적인 반려동물 문화가 될 수 있도록 시민 여러분의\n많은 관심과 성원 부탁드립니다.\n☏ 02-2124-2839\n☏ 02-2124-2839");
			System.out.println("\t\t<<시스템을 종료합니다.>>");
			System.exit(0);
		}

	
	public void select(){				//동물 선택
		System.out.print("[ 동물 선택하기 : 1] [ 메인 메뉴로 : 2] [ 종료 : 0 ]  >> ");
		Scanner scann = new Scanner(System.in);
		String sc = scann.nextLine();
		int num = Integer.parseInt(sc);
		if (num == 1)
		{
			System.out.print("\t\t원하는 동물의 번호를 입력하세요 >> ");
			String select = scann.nextLine();
			int num2 = Integer.parseInt(select);
			for ( int i = 0 ; i < db.petInfo.length ; i++)
			{
				
				if (num2 == i)
				{
					System.out.printf("\t♥%s(이)를 선택하셨습니다♥\n",dto[i].getPetName());
					mLine('-',70);
					System.out.printf("\t이름 : %s\n\t종 : %s\n\t품종 : %s\n\t성별 : %s\n\t나이 : %s세\n\t몸무게 : %skg\n",dto[i].getPetSex(),dto[i].getPetSp(),dto[i].getPetKind(),dto[i].getPetSex(),dto[i].getPetAge(),dto[i].getPetWeight());
					mLine('-',70);
					System.out.printf("소개영상 : %s\n",dto[i].getPetVideo());
					mLine('-',70);
					System.out.print("[ 가까운 병원 추천 : 1 ] [ 메인 메뉴로 : 2 ] [ 종료 : 0 ]" );
					String select2 = scann.nextLine();
					int num3 = Integer.parseInt(select2);
					if (num3 == 1)
					{
						while (true)
						{
							hospiRecommend();
						}
						
					}
					if (num3 ==2)
					{
						intro();
					}
					if (num3 ==0)
					{
						exit();
					}
					else {
						menuerror();
						}

				}
			}
		}
		if (num == 2)
		{
			intro();
		}
		if (num == 0)
		{
			exit();
		}
		else {
			menuerror();
		}
	}



	void petList(){			// 동물 리스트 출력
		mLine('-',70);
		System.out.printf("%-6s%-6s%-7s%-13s%-7s%-6s%-6s\n","번호","이름","종","품종","성별","나이","몸무게");
		mLine('-',70);
		for ( int i = 0 ; i < db.petInfo.length ; i++ )
		{
			System.out.printf(" %s\t%s\t%s\t%-6s\t%s\t%s\t%s\n",dto[i].getPetNum(),dto[i].getPetName(),dto[i].getPetSp(),dto[i].getPetKind(),dto[i].getPetSex(),dto[i].getPetAge(),dto[i].getPetWeight());
		}
		mLine('-',70);
		select();	
	}
	void dogList(){  // 강아지 리스트 출력
			mLine('-',70);
			System.out.printf("%-6s%-6s%-7s%-13s%-7s%-6s%-6s\n","번호","이름","종","품종","성별","나이","몸무게");
			mLine('-',70);
			for (int i = 0 ; i < db.petInfo.length ; i++ )
			{
				if (dto[i].getPetSp() == "DOG")
				{
					System.out.printf(" %s\t%s\t%s\t%-6s\t%s\t%s\t%s\n",dto[i].getPetNum(),dto[i].getPetName(),dto[i].getPetSp(),dto[i].getPetKind(),dto[i].getPetSex(),dto[i].getPetAge(),dto[i].getPetWeight());
				}
			}
			mLine('-',70);
	}
	void catList(){  // 고양이 리스트 출력
			mLine('-',70);
			System.out.printf("%-6s%-6s%-7s%-13s%-7s%-6s%-6s\n","번호","이름","종","품종","성별","나이","몸무게");
			mLine('-',70);
			for (int i = 0 ; i < db.petInfo.length ; i++ )
			{
				if (dto[i].getPetSp() == "CAT")
				{
					System.out.printf(" %s\t%s\t%s\t%-6s\t%s\t%s\t%s\n",dto[i].getPetNum(),dto[i].getPetName(),dto[i].getPetSp(),dto[i].getPetKind(),dto[i].getPetSex(),dto[i].getPetAge(),dto[i].getPetWeight());
				}
			}
			mLine('-',70);
}

	
	void spSearch(){			//품종으로 검색
		System.out.print("\t\t찾으시는 품종을 입력하세요 >> ");
		Scanner scann = new Scanner(System.in);
		String sc = scann.nextLine();
		mLine('-',70);
		System.out.printf("%-6s%-6s%-7s%-13s%-7s%-6s%-6s\n","번호","이름","종","품종","성별","나이","몸무게");
		mLine('-',70);
		int flag = 0;
		for ( int i = 0; i < db.petInfo.length  ; i++)
		{
			if (sc.contains(dto[i].getPetKind()))
			{
			flag++;
			System.out.printf(" %s\t%s\t%s\t%-6s\t%s\t%s\t%s\n",dto[i].getPetNum(),dto[i].getPetName(),dto[i].getPetSp(),dto[i].getPetKind(),dto[i].getPetSex(),dto[i].getPetAge(),dto[i].getPetWeight());
	
			}
		}
		
		if (flag == 0)
		{
			System.out.println("\t\t찾으시는 품종이 없습니다");
		}
		else {
			select();}
	} //품종 검색 (없을시 "찾으시는 품종이 없습니다")
	
	void dogSize(){
		mLine('-',70);
		System.out.printf("%-6s%-6s%-7s%-13s%-7s%-6s%-6s\n","번호","이름","종","품종","성별","나이","몸무게");
		mLine('-',70);
		for ( int i = 0 ; i < db.petInfo.length ; i++ )
		{
			if (Double.parseDouble(dto[i].getPetWeight()) < 8)
			{
			System.out.printf(" %s\t%s\t%s\t%-6s\t%s\t%s\t%s\n",dto[i].getPetNum(),dto[i].getPetName(),dto[i].getPetSp(),dto[i].getPetKind(),dto[i].getPetSex(),dto[i].getPetAge(),dto[i].getPetWeight());
			}
		}
		mLine('-',70);
	} 
	void dogSize2(){
		mLine('-',70);
		System.out.printf("%-6s%-6s%-7s%-13s%-7s%-6s%-6s\n","번호","이름","종","품종","성별","나이","몸무게");
		mLine('-',70);
		for ( int i = 0 ; i < db.petInfo.length ; i++ )
		{
			if (Double.parseDouble(dto[i].getPetWeight())>= 8)
			{
			System.out.printf(" %s\t%s\t%s\t%-6s\t%s\t%s\t%s\n",dto[i].getPetNum(),dto[i].getPetName(),dto[i].getPetSp(),dto[i].getPetKind(),dto[i].getPetSex(),dto[i].getPetAge(),dto[i].getPetWeight());
			}
		}
		mLine('-',70);
	} 
	void place(){
		System.out.print("마포 센터\t\t\t구로 센터\n");
		mLine('-',70);
		System.out.printf("%s\t%s\n","마포구 매봉산로 지하 1층","구로구 경인로472");
		mLine('-',70);
		 System.out.println("[ 메인 메뉴로 : 1 ] [ 종료 : 0 ]");
		   Scanner scann = new Scanner(System.in);
		   String sc = scann.nextLine();
			int num = Integer.parseInt(sc);
			if ( num == 1)
			{
				intro();
			}
			if ( num == 0)
			{
				exit();
			}
			

	}	
}
